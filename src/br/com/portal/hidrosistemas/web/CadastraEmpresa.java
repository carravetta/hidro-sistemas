package br.com.portal.hidrosistemas.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.portal.hidrosistemas.model.Empresa;
import br.com.portal.hidrosistemas.util.JPAUtil;

public class CadastraEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		HttpSession session = req.getSession();
		session.removeAttribute("erroCadastro");
		session.removeAttribute("sucessoCadastro");
		
		if(session.getAttribute("sucessoCadastro") != null) {
			return "/WEB-INF/paginas/verificacao.jsp";
		}
		
		String razaosocial = req.getParameter("razaoSocial");
		String fantasia = req.getParameter("fantasia");
		String cnpj_cpf = req.getParameter("cnpj");
		String insc_estadual = req.getParameter("insc-est");
		String cep = req.getParameter("cep");
		String rua = req.getParameter("rua");
		int numero = Integer.parseInt(req.getParameter("numero"));
		String bairro = req.getParameter("bairro");
		String cidade = req.getParameter("cidade");
		String estado = req.getParameter("estado");
		String fone = req.getParameter("tel");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

			Empresa novaEmpresa = new Empresa(razaosocial, fantasia, cnpj_cpf.replaceAll("\\./", ""), insc_estadual, rua, bairro, cidade,
					estado, cep, fone, email, senha, numero);
			
			if (razaosocial == "" || fantasia == "" || cnpj_cpf == "" || insc_estadual == "" || rua == "") {
				if (bairro == "" || cidade == "" || estado == "" || cep == "" || fone == "" || email == ""
						|| senha == "") {
					session.setAttribute("erroCadastro", "Falha ao cadastrar, verificar campos");
					return "/WEB-INF/paginas/verificacao.jsp";
				}
			}
			EntityManager em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			
			if (buscaEmpresaCadastrada(novaEmpresa) == false) {
				
				em.persist(novaEmpresa);
				em.getTransaction().commit();
				session.setAttribute("sucessoCadastro", "Empresa " + fantasia + " cadastrada com sucesso!");
				
			}
			else {
				session.setAttribute("erroCadastro", "Empresa já cadastrada, favor verificar");
			}
		

			em.close();


		return "/WEB-INF/paginas/verificacao.jsp";
	}

	
	private boolean buscaEmpresaCadastrada(Empresa empresa) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		String jpql = "select e from Empresa e";
		Query query = em.createQuery(jpql);

		List<Empresa> empresas = query.getResultList();
		em.close();
		
		for (Empresa emp : empresas) {
			if (emp.getCnpj_cpf().equals(empresa.getCnpj_cpf())) 
				return true;
				if(emp.getRazaoSocial().equals(empresa.getRazaoSocial()))
					return true;
					if(emp.getInscEstadual().equals(empresa.getInscEstadual()))
						return true;
		}

		return false;
	}
	
}

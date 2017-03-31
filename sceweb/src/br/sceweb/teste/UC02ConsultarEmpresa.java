package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;
/**
 * 
 * @author Lab103
 * @version 2017-03-31
 * caso de teste consulta empresa
 */
public class UC02ConsultarEmpresa { // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
/**
 * resultado esperado
 */
	static Empresa ResultadoEsperado;
	/**
	 * resultado obtido
	 */
	static Empresa ResultadoObtido;
	/**
	 * empresa dao
	 */
	static EmpresaDAO EEmpresaDAO;
/**
 * pre condicoes antes da execucao da classe
 * @throws Exception
 */
	@BeforeClass
	public static void setUpBeforeClass() {
		ResultadoEsperado = new Empresa();
		EEmpresaDAO = new EmpresaDAO();
		ResultadoEsperado.setNomeDaEmpresa("empresa x");
		ResultadoEsperado.setCnpj("89424232000180");
		ResultadoEsperado.setNomeFantasia("empresa x");
		ResultadoEsperado.setEndereco("rua taquari");
		ResultadoEsperado.setTelefone("2222");
		EEmpresaDAO.adiciona(ResultadoEsperado);
	}
	/**
	 * teste de consulta empresa com sucesso
	 */
	@Test
	public void cT01UC02ConsultarEmpresa_com_sucesso() {
		ResultadoObtido = EEmpresaDAO.consultaEmpresa("89424232000180");
		assertTrue(ResultadoEsperado.equals(ResultadoObtido));
	}
/**
 * condicoes pos execucao do teste
 * @throws Exception
 */
	@After
	public void excluiEmpresa() {
		EEmpresaDAO.exclui("89424232000180");
	}
/**
 * condicoes pos execucao da classe
 * @throws Exception
 */
	@AfterClass
	public static void tearDownAfterClass()  {

	}

}
package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC02ConsultarEmpresa {
	static Empresa resultadoEsperado;
	static Empresa resultadoObtido;
	
	static EmpresaDAO empresaDAO;

	@Before
	public void setUp() throws Exception {
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		resultadoEsperado = new Empresa();
		empresaDAO = new EmpresaDAO(); 
		resultadoEsperado.setNomeDaEmpresa("empresa x");
		resultadoEsperado.setCnpj("89424232000180");
		resultadoEsperado.setNomeFantasia("empresa x");
		resultadoEsperado.setEndereco("rua taquari");
		resultadoEsperado.setTelefone("2222");
		empresaDAO.adiciona(resultadoEsperado);
		
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	//empresaDAO.exclui(cnpj)
		
	}
	/**
	 * 
	 * @throws Exception
	 */
	
	@After
	public void exluiEmpresa() throws Exception {
	empresaDAO.exclui("89424232000180");
		
	}

	@Test
	public void CT01UC02Consultar_Empresa_Com_Sucesos() {
		resultadoObtido = empresaDAO.consulta("89424232000180");
		assertTrue(resultadoEsperado.equals(resultadoObtido));
		
	}

}

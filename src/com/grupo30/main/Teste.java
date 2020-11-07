package com.grupo30.main;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.grupo30.dao.*;
import com.grupo30.enums.TipoRefeicao;
import com.grupo30.model.*;

public class Teste {

	public static void main(String[] args) throws ParseException {
		DateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("=========================");
		generateAlimentos(dtf);
		System.out.println("=========================");
		generateAtividade(dtf);
		System.out.println("=========================");
		generateBatimentoCardiaco(dtf);
		System.out.println("=========================");
		generatePesos(dtf);
		System.out.println("=========================");
		generateRefeicao(dtf);
		System.out.println("=========================");
	}
	
	private static void generateAlimentos(DateFormat dtf) throws ParseException {
		AlimentoDao alimentoDao = new AlimentoDao();
		alimentoDao.insert(new Alimento("Alface", 32.0, 2, dtf.parse("10/09/2020")));
		alimentoDao.insert(new Alimento("Tomate", 20.0, 1, dtf.parse("10/09/2020")));
		alimentoDao.insert(new Alimento("Arroz", 130.0, 1, dtf.parse("10/09/2020")));
		alimentoDao.insert(new Alimento("Feijão", 100.0, 1, dtf.parse("12/09/2020")));
		alimentoDao.insert(new Alimento("Suco de Laranja", 45.0, 1, dtf.parse("12/09/2020")));
		
		List<Alimento> alimentos = alimentoDao.getAll();
		
		for(Alimento alimento : alimentos) {
			System.out.println(alimento.toString());
		}
	}
	
	private static void generateAtividade(DateFormat dtf) throws ParseException {
		AtividadeDao atividadeDao = new AtividadeDao();
		atividadeDao.insert(new Atividade("Esteira", 1800, dtf.parse("12/09/2020")));
		atividadeDao.insert(new Atividade("Agachamento", 300, dtf.parse("12/09/2020")));
		atividadeDao.insert(new Atividade("Remada Curvada", 300, dtf.parse("12/09/2020")));
		atividadeDao.insert(new Atividade("Ponte", 600, dtf.parse("20/10/2020")));
		atividadeDao.insert(new Atividade("Abdominal", 300, dtf.parse("20/10/2020")));
		
		List<Atividade> atividades = atividadeDao.getAll();
		
		for(Atividade atv : atividades) {
			System.out.println(atv.toString());
		}
	}
	
	private static void generateBatimentoCardiaco(DateFormat dtf) throws ParseException {
		BatimentoCardiacoDao batimentoCardiacoDao = new BatimentoCardiacoDao();
		batimentoCardiacoDao.insert(new BatimentoCardiaco(70, 120, 100, dtf.parse("09/09/2020")));
		batimentoCardiacoDao.insert(new BatimentoCardiaco(80, 122, 98, dtf.parse("02/10/2020")));
		batimentoCardiacoDao.insert(new BatimentoCardiaco(65, 110, 89, dtf.parse("10/10/2020")));
		batimentoCardiacoDao.insert(new BatimentoCardiaco(72, 105, 101, dtf.parse("15/10/2020")));
		batimentoCardiacoDao.insert(new BatimentoCardiaco(68, 115, 103, dtf.parse("20/10/2020")));
		
		List<BatimentoCardiaco> batimentos = batimentoCardiacoDao.getAll();
		
		for(BatimentoCardiaco bat : batimentos) {
			System.out.println(bat.toString());
		}
		
	}
	
	private static void generatePesos(DateFormat dtf) throws ParseException {
		PesoDao pesoDao = new PesoDao();
		pesoDao.insert(new Peso(82.0, dtf.parse("10/09/2020")));
		pesoDao.insert(new Peso(80.0, dtf.parse("26/09/2020")));
		pesoDao.insert(new Peso(78.0, dtf.parse("05/10/2020")));
		pesoDao.insert(new Peso(77.0, dtf.parse("10/10/2020")));
		pesoDao.insert(new Peso(76.0, dtf.parse("20/10/2020")));
		
		List<Peso> pesos = pesoDao.getAll();
		
		for(Peso peso : pesos) {
			System.out.println(peso.getCodPeso() + " - " + peso.getValor() + "kg em " + dtf.format(peso.getDtPesagem()));
		}
	}
	
	private static void generateRefeicao(DateFormat dtf) throws ParseException {
		RefeicaoDao refeicaoDao = new RefeicaoDao();
		refeicaoDao.insert(new Refeicao(TipoRefeicao.ALMOCO, dtf.parse("09/09/2020")));
		refeicaoDao.insert(new Refeicao(TipoRefeicao.CAFEMANHA, dtf.parse("02/10/2020")));
		refeicaoDao.insert(new Refeicao(TipoRefeicao.CAFETARDE, dtf.parse("10/10/2020")));
		refeicaoDao.insert(new Refeicao(TipoRefeicao.CEIA, dtf.parse("15/10/2020")));
		refeicaoDao.insert(new Refeicao(TipoRefeicao.JANTA, dtf.parse("20/10/2020")));
		
		List<Refeicao> refeicoes = refeicaoDao.getAll();
		
		for(Refeicao ref : refeicoes) {
			System.out.println(ref.toString());
		}
		
	}
}

/*
 * Projeto final ECOT13-T02 2023
 * prof Enzo Serephim
 * Tema: Bleach (anime)
 * Por Lucas Luan Belarmino Barbosa, 2021017872
 * 
 * informações sobre o anime podem ser obtidas em:
 * https://bleach.fandom.com/pt/wiki/Bleach_Wiki
 */
package br.edu.unifei.bleach;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		//criação dos mundos
		EntityManagerFactory emf
        = Persistence.createEntityManagerFactory("bleach");
		EntityManager em = emf.createEntityManager();
		
		Mundo mundoHumano = new Mundo(WorldType.MUNDO_FISICO);
		Mundo mundoDasAlmas = new Mundo(WorldType.SOUL_SOCYETY);
		Mundo mundoAssombroso = new Mundo(WorldType.HUECO_MUNDO);
		
		//criação dos locais principais
		Local cidadePrincipal = new Cidade("Karakura",mundoHumano);
		mundoHumano.addLocal(cidadePrincipal);
		
		Local sereitei = new Cidade("Sereitei",mundoDasAlmas);
		Local cidadeDasAlmas = new Cidade("Rukongai",mundoDasAlmas);
		mundoDasAlmas.addLocal(cidadeDasAlmas);
		mundoDasAlmas.addLocal(sereitei);
		
		Local lasNotches = new Cidade("Las Notches",mundoAssombroso);
		Local deserto = new Deserto(mundoAssombroso);
		deserto.setNome("Deserto Branco");
		mundoAssombroso.addLocal(lasNotches);
		mundoAssombroso.addLocal(deserto);
		
		//criando organizacao principal
		Organizacao primeira = new Organizacao();
		primeira.setNome("Primeira Divisao");
		primeira.setRegras("Manter a ordem");
		
		Organizacao decimaPrimeira = new Organizacao();
		decimaPrimeira.setNome("Decima Primeira Divisao");
		decimaPrimeira.setRegras("Lutar sem depender dos outros");
		decimaPrimeira.setInimigos("Qualquer um que seja forte");
		
		Organizacao sexta = new Organizacao();
		sexta.setNome("Sexta Divisao");
		sexta.setRegras("Resiliencia");
		
		Organizacao gotei13 = new Organizacao();
		gotei13.setNome("Gotei 13");
		gotei13.setRegras("Manter o equilibrio entre os mundos");
		gotei13.setInimigos("Qualquer um que tente quebrar o equilibrio");
		gotei13.getGruposInternos().add(primeira);
		gotei13.getGruposInternos().add(sexta);
		gotei13.getGruposInternos().add(decimaPrimeira);

//-------------------------primeiro persist-------------------------------------
//		em.getTransaction().begin();
//		em.persist(cidadePrincipal);
//		em.persist(sereitei);
//		em.persist(cidadeDasAlmas);
//		em.persist(lasNotches);
//		em.persist(deserto);
//		
//		em.persist(mundoHumano);
//		em.persist(mundoDasAlmas);
//		em.persist(mundoAssombroso);
//		em.getTransaction().commit();
//		
//		em.getTransaction().begin();
//		em.persist(primeira);
//		em.persist(decimaPrimeira);
//		em.persist(sexta);
//		em.persist(gotei13);
//		em.getTransaction().commit();
//----------------------------------------------------------------------------
		//criando ataque basico
		Habilidade aa = new Habilidade();
		aa.setDescricao("Ataque normal utilizando a arma que tem\nCaso nao haja arma usa os punhos");
		aa.setEfeito(2);
		aa.setGasto(0);
		aa.setNome("Ataque basico");
		aa.setTipo(EnumHabilidade.DANO);

		//criando personagens
		Shinigami shiP = new Shinigami();
		Ser protagonista = new Ser(shiP);
		protagonista.setLocalAtual(cidadePrincipal);
		protagonista.setNome("Ichigo Kurosaki");
		protagonista.setReiatsu(5);
		protagonista.setOrganizacao(gotei13);
		cidadePrincipal.getHabitantes().add(protagonista);
		protagonista.setEspada(new Armamento("Zanguetsu",ArmType.SHINKAI));
		protagonista.getEspada().getHabilidade().set(0, aa);
		protagonista.getHabilidades().add(aa);

		Shinigami cap1 = new Shinigami();
		Ser capitao1 = new Ser(cap1);
		capitao1.setNome("Yamamoto");
		capitao1.setLocalAtual(sereitei);
		capitao1.getRaca().setReservaEspiritual(500);
		capitao1.setReiatsu(35);
		capitao1.setOrganizacao(primeira);
		capitao1.setEspada(new Armamento("Ryujin Jakka",ArmType.SHINKAI));
		capitao1.getEspada().getHabilidade().set(0, aa);

		Shinigami cap2 = new Shinigami();
		Ser capitao2 = new Ser(cap2);
		capitao2.setNome("Zaraki");
		capitao2.setLocalAtual(sereitei);
		capitao2.getRaca().setReservaEspiritual(500);
		capitao2.setReiatsu(50);
		capitao2.setOrganizacao(decimaPrimeira);
		capitao2.setEspada(new Armamento("Nozarashi",ArmType.ZANPAKUTO));
		capitao2.getEspada().getHabilidade().set(0, aa);
		
		Shinigami cap3 = new Shinigami();
		Ser capitao3 = new Ser(cap3);
		capitao3.setNome("Byakuia");
		capitao3.setLocalAtual(sereitei);
		capitao3.setReiatsu(10);
		capitao3.setOrganizacao(sexta);
		capitao3.setEspada(new Armamento("Senbonzakura",ArmType.SHINKAI));
		capitao3.getEspada().getHabilidade().set(0, aa);
		
		sereitei.getHabitantes().add(capitao3);
		sereitei.getHabitantes().add(capitao2);
		sereitei.getHabitantes().add(capitao1);
		
		primeira.getMembros().add(capitao1);
		sexta.getMembros().add(capitao2);
		decimaPrimeira.getMembros().add(capitao3);
		gotei13.getMembros().add(protagonista);
		
		Humano u = new Humano();
		Ser uryu = new Ser(u);
		uryu.setNome("Ishida Uryu");
		uryu.setReiatsu(2);
		uryu.setLocalAtual(cidadePrincipal);
		cidadePrincipal.getHabitantes().add(uryu);
		
		Armamento armaQuincy = new Armamento(" ", ArmType.ARMAMENTO_ESPIRITUAL);
		armaQuincy.setDescricao("Um pingente em forma de cruz que cria uma arco com energia espiritual");
		armaQuincy.getHabilidade().set(0, aa);
		armaQuincy.setNome("Cruz Quincy");
		armaQuincy.setQuebrado(false);
		uryu.setEspada(armaQuincy);


		Arrancar ar = new Arrancar();
		Ser ulquiorra = new Ser(ar);
		ulquiorra.setLocalAtual(lasNotches);
		ulquiorra.setMorto(true);
		ulquiorra.setNome("Ulquiorra");
		ulquiorra.setReiatsu(3);
		lasNotches.getHabitantes().add(ulquiorra);
		
		ulquiorra.setEspada(new Armamento("Espada", ArmType.ZANPAKUTO));
		ulquiorra.getEspada().getHabilidade().set(0, aa);
		
		
		Hollow h = new Hollow();
		Ser bonbocacha = new Ser(h);
		bonbocacha.setNome("Bonbocacha");
		bonbocacha.setLocalAtual(lasNotches);
		lasNotches.getHabitantes().add(bonbocacha);
		bonbocacha.setReiatsu(5);

		Alma a = new Alma();
		Ser almaQualquer = new Ser(a);
		almaQualquer.setNome("desconhecido");
		//almaQualquer.getRaca().setId(7);
		almaQualquer.setLocalAtual(cidadePrincipal);
		sereitei.getHabitantes().add(almaQualquer);
		
//-------------------------segundo persist-------------------------------------			
//		em.getTransaction().begin();
//		em.persist(aa);
//		em.getTransaction().commit();
		
//-----------------------------------------------------------------------------
//		em.getTransaction().begin();
//		em.persist(shiP);
//		em.persist(a);
//		em.persist(h);
//		em.persist(ar);
//		em.persist(u);
//		em.persist(cap3);
//		em.persist(cap2);
//		em.persist(cap1);
//		em.getTransaction().commit();
//
//		em.getTransaction().begin();
//		em.persist(protagonista.getEspada());
//		em.persist(capitao1.getEspada());
//		em.persist(capitao2.getEspada());
//		em.persist(capitao3.getEspada());
//		em.persist(armaQuincy);
//		em.persist(ulquiorra.getEspada());
//		em.getTransaction().commit();
//
//		em.getTransaction().begin();
//		em.persist(protagonista);
//		em.persist(almaQualquer);
//		em.persist(bonbocacha);
//		em.persist(ulquiorra);
//		em.persist(uryu);
//		em.persist(capitao3);
//		em.persist(capitao2);
//		em.persist(capitao1);
//		em.getTransaction().commit();
//		
//		em.getTransaction().begin();
//		em.merge(primeira);
//		em.merge(decimaPrimeira);
//		em.merge(sexta);
//		em.merge(gotei13);
//		em.merge(sereitei);
//		em.merge(deserto);
//		em.merge(lasNotches);
//		em.merge(cidadeDasAlmas);
//		em.merge(cidadePrincipal);
		
		Armamento ichigoBankai = new Armamento("",ArmType.BANKAI);
		ichigoBankai.setNome("Tensa Zangetsu");
		ichigoBankai.especial().setNome("Getsuga Tensho");
		ichigoBankai.especial().setEfeito(25);
		ichigoBankai.especial().setTipo(EnumHabilidade.DANO);
		ichigoBankai.setDescricao("Katana negra");
		ichigoBankai.getHabilidade().add(aa);
			
		protagonista.getHabilidades().add(ichigoBankai.especial());
		//ichigo ativa sua bankai
		protagonista.getEspada().liberar(protagonista, ichigoBankai);
		
		capitao2.getRaca().setDefesa(19);
		protagonista.getRaca().setForca(20);
		
//
//		em.persist(ichigoBankai.especial());
//		em.persist(ichigoBankai);
//		em.merge(capitao2);
//		em.merge(protagonista);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
}

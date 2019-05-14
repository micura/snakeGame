package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 * @author  Adam Micura
 * @version 1.0
 * @since   2019.03-31
 *
 * Az {@link model.Toplist} osztály reprezentálja a toplistát.
 */
public class Toplist {
    private static EntityManager em;

    /**
     * Az osztály konstruktora.
     *
     * @see EntityManagerFactory
     */
    public Toplist() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
        em = emf.createEntityManager();
    }

    /**
     * Beszúr egy új sort a toplistába.
     *
     * @param name A játékos neve
     * @param score A játékos pontszáma
     * @param date A jelenlegi dátum
     */
    public void newRecord(String name, int score, String date) {
        Main.log.info("Felkerültél a toplistára");
        em.getTransaction().begin();
        Player emp = new Player(name, score, date);
        em.persist(emp);
        em.getTransaction().commit();
    }

    /**
     * Visszaadja az eddigi játékosok listáját a pont függvényében csökkenő sorrendben.
     *
     * @return Egy játékosokból álló lista, pontszám szerint csökkenő sorrendben.
     */
    public static List<Player> getAll() {
        String certificationQuery = "SELECT plays FROM Player plays ORDER BY plays.score DESC";
        try {
            TypedQuery<Player> qCertification = em.createQuery(certificationQuery, Player.class);
            return qCertification.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.example.test;

import java.util.List;

/**
 * @author Alejandro Duarte
 */
public class ComentarioRepository {

    public static List<Comentario> findAll() {
        return JPAService.runInTransaction(em ->
                em.createQuery("select c from Comentario c").getResultList()
        );
    }

    public static void save(Comentario comentario) {
        JPAService.runInTransaction(em -> {
            em.persist(comentario);
            return null;
        });
    }

}
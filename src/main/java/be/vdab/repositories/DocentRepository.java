package be.vdab.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import be.vdab.entities.Docent;

public class DocentRepository extends AbstractRepository {
public Optional<Docent> read(long id) {
return Optional.ofNullable(getEntityManager().find(Docent.class, id));
}

public void create(Docent docent) {
getEntityManager().persist(docent);
}

public void delete(long id) {
read(id).ifPresent(docent -> getEntityManager().remove(docent));
}

public List<Docent> findByWeddeBetween(BigDecimal van, BigDecimal tot,
int vanafRij, int aantalRijen) {
return getEntityManager().createNamedQuery("Docent.findByWeddeBetween", Docent.class)
.setParameter("van", van)
.setParameter("tot", tot)
.setFirstResult(vanafRij)
.setMaxResults(aantalRijen)
.getResultList();
}

public List<String> findVoornamen() {
return getEntityManager().createQuery(
"select d.voornaam from Docent d", String.class).getResultList();
}

public BigDecimal findMaxWedde() {
return getEntityManager().createQuery(
"select max(d.wedde) from Docent d", BigDecimal.class).getSingleResult();
}

}
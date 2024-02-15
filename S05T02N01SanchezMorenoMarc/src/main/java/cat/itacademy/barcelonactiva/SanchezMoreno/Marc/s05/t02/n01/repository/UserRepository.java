package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.domain.Usuario;

@Repository
public interface UserRepository extends JpaRepository <Usuario, Integer> {

	public Usuario findByName(String name);
}
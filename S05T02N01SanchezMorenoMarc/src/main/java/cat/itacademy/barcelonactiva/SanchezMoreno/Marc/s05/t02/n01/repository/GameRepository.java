package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.domain.Game;

@Repository
public interface GameRepository extends JpaRepository <Game, Integer> {

}
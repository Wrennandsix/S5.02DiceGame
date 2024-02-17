package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.services;

import org.springframework.stereotype.Service;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.domain.Game;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.domain.Usuario;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.dto.GameDTO;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.dto.UsuarioDTO;
import java.util.List;



@Service
public interface UserService {
	public void updateUser(Integer id, UsuarioDTO userDTO);
	public void saveUser(UsuarioDTO registroDto);
	public Usuario findUser(String username);
	public List<Usuario> getAllUsers();
	public List<Game> getUserGames(int user_id);
	public Usuario findById(int user_id);
	public Usuario findRepeatedUser(String name);
	public double calculateAllAverageRate();
	public List<Game> listGames();
	public Game saveGame(Game game);
	public double calculateUserAverageRate(int id);
	public Usuario userDTOToUser(UsuarioDTO userRegisterDTO);
	public UsuarioDTO userToDTO(Usuario userRegister);
	public Usuario getUser(Integer id);
	public Game playGame(Integer id);
	public void deleteAllGames(Integer id);
	public List<UsuarioDTO> getUsersAverageRate();
	public UsuarioDTO getLoser();
	public UsuarioDTO getWinner();
	public void recalculateAverage(Integer id);
	Usuario userDTOToUserAnonymus(UsuarioDTO userRegisterDTOAnonymus);
	GameDTO gameToGameDTO(Game game);
	List<GameDTO> gameListToGameListDTO(List<Game> games);
}	

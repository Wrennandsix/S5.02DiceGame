package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.domain.Game;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.domain.Usuario;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.dto.UsuarioDTO;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.exceptions.ExistingNameException;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.exceptions.GamesNotPlayedException;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.exceptions.NotExistingUsersException;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.exceptions.UserNotFoundException;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.repository.GameRepository;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t02.n01.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserRepository usersRepo;

	@Autowired
	private GameRepository gameRepo;



	@Override
	public Usuario findUser(String username) {
		
		Usuario user = null;
		try {
			user = usersRepo.findByName(username);
		} catch ( UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	@Override
	public List<Game> getUserGames(int id) {
		
		ArrayList<Game> games = new ArrayList<>();

		for (int i = 0; i < gameRepo.findAll().size(); i++) {
			if (gameRepo.findAll().get(i).getUserId() == id) {
				games.add(gameRepo.findAll().get(i));
			}

		}
		if(games.isEmpty()) {
			throw new GamesNotPlayedException();
		}
		return games;
	}

	@Override
	public Usuario findRepeatedUser(String name) {
		List<Usuario> userList = usersRepo.findAll();
		
		if (userList.isEmpty()) {
			Usuario firstUser = new Usuario("firstUser");			
			return firstUser;
		}

		Optional<Usuario> repeatedUser = userList.stream().filter(u -> u.getName().equalsIgnoreCase(name))
				.findFirst();

		return repeatedUser.orElse(null);
	}
	
	@Override
	public void saveUser(UsuarioDTO registerDTO) {

		Usuario registerUser = userDTOToUser(registerDTO);
		Usuario repeatedUser = findRepeatedUser(registerUser.getName());
		
		if (repeatedUser == null) {
			usersRepo.save(registerUser);
			return;
		}
		if (registerUser.getName().equalsIgnoreCase(repeatedUser.getName())) {
			throw new ExistingNameException();
		} else {
			usersRepo.save(registerUser);
		}
	}

	@Override
	public double calculateAllAverageRate() {
		List<Game> games = gameRepo.findAll();

		long victories = games.stream().filter(game -> game.getResult().equalsIgnoreCase("Victory!")).count();

		long defeats = games.size() - victories;

		double averageRate = 0;
		if (victories + defeats > 0) {
			averageRate = (double) victories / (victories + defeats) * 100;
		}

		return averageRate;
	}

	@Override
	public double calculateUserAverageRate(int id) {

		List<Game> games = getUserGames(id);
	
		double averageRate = 0;

		if (games == null || games.isEmpty()) {
			return 0.0;
		}

		long victories = games.stream().filter(game -> game.getResult().equalsIgnoreCase("Victory!")).count();

		long defeats = games.size() - victories;
		
		averageRate = (double) victories / (victories + defeats) * 100;

		return averageRate;
	}
	

	@Override
	public List<Game> listGames() {
		return gameRepo.findAll();
	}

	@Override
	public Game saveGame(Game game) {
		return gameRepo.save(game);
	}


	@Override
	public List<Usuario> getAllUsers() {
		return usersRepo.findAll();
	}

	@Override
	public Usuario findById(int id) {
		return usersRepo.findById(id).get();
	}


    @Override
    public Usuario userDTOToUser(UsuarioDTO userRegisterDTO){
        return new Usuario(userRegisterDTO.getName());
    }
    
	@Override
	public UsuarioDTO userToDTO(Usuario userRegister) {
		return new UsuarioDTO(userRegister.getName(), userRegister.getAverageRate());
	}
	

	@Override
	public void updateUser(Integer id, UsuarioDTO userDTO) {
		
	        Usuario user = getUser(id);
	       
	        Usuario existingUser = usersRepo.findByName(userDTO.getName());
	        System.out.println(userDTO.getName());
	        if(existingUser != null){
	            if(existingUser.getId() != user.getId()){
	                throw new ExistingNameException();
	            }
	        }
	        user.setName(userDTO.getName());
	        usersRepo.save(user);
	    }
    @Override
    public Usuario getUser(Integer id) {
    	
        Optional<Usuario> user = usersRepo.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException();
        }
        return user.get();
    }
    
    

	@Override
	public Game playGame(Integer id) {

		Usuario userPlaying = getUser(id);

		Game game = new Game(id);

		return game;
	}

	public void recalculateAverage(Integer id) {
	 Double newAverage = calculateUserAverageRate(id);  
	
	 Usuario user = getUser(id);
	 user.setAverageRate(newAverage);	
     
     usersRepo.save(user);
	
}
	
	@Override
	public void deleteAllGames(Integer id) { 
		
	    List<Game> userGames = getUserGames(id);
	    
	    for (Game game : userGames) {
	        gameRepo.delete(game);
	    }
	   Usuario currentUser = getUser(id);
	   currentUser.setAverageRate(0.0);
	   usersRepo.save(currentUser);
	}

	@Override
	public List<UsuarioDTO> getUsersAverageRate() {
		   
	    List<Usuario> userList = usersRepo.findAll();
	    if(userList.isEmpty()) {
	    	throw new NotExistingUsersException();
	    }
	    List<UsuarioDTO> userDTOList = new ArrayList<>();
	   
	    
	    if (userList != null) {
	        userList.forEach(u -> {
	            if (u != null) {
	                userDTOList.add(new UsuarioDTO(u.getName(), u.getAverageRate()));
	            }
	        });
	    }

	    return userDTOList;
	}
	@Override
	public UsuarioDTO getLoser() {
		
	    List<UsuarioDTO> userDTOList = getUsersAverageRate();
	    return userDTOList
	            .stream()
	            .filter(u -> u.getAverageRate() != null)
	            .min(Comparator.comparing(UsuarioDTO::getAverageRate))
	            .orElseThrow(GamesNotPlayedException::new);
	}
	@Override
	public UsuarioDTO getWinner() {
		
	    List<UsuarioDTO> userDTOList = getUsersAverageRate();
	    return userDTOList
	            .stream()
	            .filter(u -> u.getAverageRate() != null)
	            .max(Comparator.comparing(UsuarioDTO::getAverageRate))
	            .orElseThrow(GamesNotPlayedException::new);
	}


}


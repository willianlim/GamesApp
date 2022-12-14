package com.spring.gamesapp.service;

import com.spring.gamesapp.model.Game;
import com.spring.gamesapp.repository.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public String testar() {
        return "Olá mundo";
    }

    @GetMapping("/api/games")
    public List<Game> listar() {
        return gameRepository.findAll();
    }

    @GetMapping("/api/games/{id}")
    public Game listarJogoPorId(@PathVariable Long id) {
        return gameRepository.findById(id).get();
    }

    @PostMapping("/api/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game save(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    @DeleteMapping("/api/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        gameRepository.deleteById(id);
    }

    @PutMapping("/api/games/{id}")
    public Game atualizar(@PathVariable Long id, @RequestBody Game game) {
        Game gameAtual = gameRepository.findById(id).get();

        BeanUtils.copyProperties(game, gameAtual, "id");
        return gameRepository.save(gameAtual);
    }

}

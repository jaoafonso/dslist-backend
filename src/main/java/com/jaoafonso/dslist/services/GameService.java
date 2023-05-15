package com.jaoafonso.dslist.services;

import com.jaoafonso.dslist.dto.GameDTO;
import com.jaoafonso.dslist.dto.GameMinDTO;
import com.jaoafonso.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        return new GameDTO(gameRepository.findById(id).get());
        // Tratamento de exceções será implementado futuramente
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        return gameRepository.searchByList(listId).stream().map(GameMinDTO::new).toList();
    }
}

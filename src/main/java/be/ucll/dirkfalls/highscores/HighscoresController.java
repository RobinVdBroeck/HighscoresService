package be.ucll.dirkfalls.highscores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;

@RestController
public class HighscoresController {
    private final HighscoresEntryRepository highscoresEntryRepository;

    public HighscoresController(HighscoresEntryRepository highscoresEntryRepository) {
        this.highscoresEntryRepository = highscoresEntryRepository;
    }

    @GetMapping("/")
    public Collection<HighscoresEntry> highscores() {
        return highscoresEntryRepository.findAllByOrderByScoreDesc();
    }

    @PostMapping("/")
    public HighscoresEntry createHighscoreEntry(@RequestBody @Valid HighscoresEntryDto dto) {
        HighscoresEntry entry = dto.convertToHighscoresEntry();
        return highscoresEntryRepository.save(entry);
    }
}

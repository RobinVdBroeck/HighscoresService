package be.ucll.dirkfalls.highscores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface HighscoresEntryRepository extends JpaRepository<HighscoresEntry, UUID> {
    Collection<HighscoresEntry> findAllByOrderByScoreDesc();
}

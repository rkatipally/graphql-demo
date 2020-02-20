package net.atpco.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import net.atpco.graphqldemo.model.Author;
import net.atpco.graphqldemo.model.Blueprint;
import net.atpco.graphqldemo.model.Tutorial;
import net.atpco.graphqldemo.repository.AuthorRepository;
import net.atpco.graphqldemo.repository.BlueprintRepository;
import net.atpco.graphqldemo.repository.TutorialRepository;

@Component
public class Query implements GraphQLQueryResolver {
    private AuthorRepository authorRepository;
    private TutorialRepository tutorialRepository;
    private BlueprintRepository blueprintRepository;

    public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository, BlueprintRepository blueprintRepository) {
        this.authorRepository = authorRepository;
        this.tutorialRepository = tutorialRepository;
        this.blueprintRepository = blueprintRepository;
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Iterable<Tutorial> findAllTutorials() {
        return tutorialRepository.findAll();
    }

    public long countAuthors() {
        return authorRepository.count();
    }

    public long countTutorials() {
        return tutorialRepository.count();
    }

    public Iterable<Tutorial> findByTitle(String title){
        return tutorialRepository.findByTitleContainingIgnoreCase(title);
    }

    public Iterable<Blueprint> getAllBlueprints() { return blueprintRepository.findAll(); }
}

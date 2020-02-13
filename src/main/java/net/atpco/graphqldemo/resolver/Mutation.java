package net.atpco.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

import net.atpco.graphqldemo.model.Author;
import net.atpco.graphqldemo.model.Blueprint;
import net.atpco.graphqldemo.model.Tutorial;
import net.atpco.graphqldemo.repository.AuthorRepository;
import net.atpco.graphqldemo.repository.BlueprintRepository;
import net.atpco.graphqldemo.repository.TutorialRepository;

@Component
public class Mutation implements GraphQLMutationResolver {
    private AuthorRepository authorRepository;
    private TutorialRepository tutorialRepository;
    private BlueprintRepository blueprintRepository;

    public Mutation(AuthorRepository authorRepository, TutorialRepository tutorialRepository, BlueprintRepository blueprintRepository) {
        this.authorRepository = authorRepository;
        this.tutorialRepository = tutorialRepository;
        this.blueprintRepository = blueprintRepository;
    }

    public Author createAuthor(String name, Integer age) {
        Author author = new Author();
        author.setName(name);
        author.setAge(age);

        authorRepository.save(author);

        return author;
    }

    public Tutorial createTutorial(String title, String description, Long authorId) {
        Tutorial tutorial = new Tutorial();
        tutorial.setAuthor(new Author(authorId));
        tutorial.setTitle(title);
        tutorial.setDescription(description);

        tutorialRepository.save(tutorial);

        return tutorial;
    }

    public boolean deleteTutorial(Long id) {
        tutorialRepository.deleteById(id);
        return true;
    }

    public Tutorial updateTutorial(Long id, String title, String description) throws NotFoundException {
        Optional<Tutorial> optTutorial = tutorialRepository.findById(id);

        if (optTutorial.isPresent()) {
            Tutorial tutorial = optTutorial.get();

            if (title != null)
                tutorial.setTitle(title);
            if (description != null)
                tutorial.setDescription(description);

            tutorialRepository.save(tutorial);
            return tutorial;
        }

        throw new NotFoundException("Not found Tutorial to update!");
    }

    public Blueprint createBlueprint(String name, String content, String owner, String createdDate){
        Blueprint blueprint = new Blueprint();
        blueprint.setContent(content);
        blueprint.setName(name);
        blueprint.setCreatedDate(createdDate);
        blueprint.setOwner(owner);

        blueprint = blueprintRepository.save(blueprint);

        return blueprint;
    }
}

package net.atpco.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import net.atpco.graphqldemo.model.Author;
import net.atpco.graphqldemo.model.Tutorial;
import net.atpco.graphqldemo.repository.AuthorRepository;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {

    private AuthorRepository authorRepository;

    public TutorialResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Tutorial tutorial) {
        return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
    }
}

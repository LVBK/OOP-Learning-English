/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package englishlearning.util;

import englishlearning.model.Article;
import englishlearning.model.Articles;
import englishlearning.model.model.IArticle;
import englishlearning.model.wrapper.ArticleWrapper;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Clicia
 */
public class TestClass {
    @Test
    public void testMethod() throws MalformedURLException {
        Collection<IArticle> test = DataInNet.getListArticle().stream()
                    .flatMap(a -> Stream.of(new ArticleWrapper(a)))
                    .collect(Collectors.toList());
        System.out.println(test.getClass().getCanonicalName());
    }
}

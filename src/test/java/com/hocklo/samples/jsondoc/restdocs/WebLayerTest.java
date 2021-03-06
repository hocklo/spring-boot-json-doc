package com.hocklo.samples.jsondoc.restdocs;

import com.hocklo.samples.jsondoc.endpoints.BooksController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BooksController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class WebLayerTest {

  @Autowired private MockMvc mockMvc;

  @Test
  public void shouldReturnDefaultMessage() throws Exception {
    this.mockMvc
        .perform(get("/books/HarryPotter"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("{\"name\":\"HarryPotter\"}"))
        .andDo(document("books"));
  }
}

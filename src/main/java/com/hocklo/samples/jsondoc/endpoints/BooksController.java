package com.hocklo.samples.jsondoc.endpoints;

import com.hocklo.samples.jsondoc.domain.Book;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiAuthNone;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.annotation.ApiVersion;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(
    name = "Books services",
    description = "Methods for managing Books",
    group = "Library",
    visibility = ApiVisibility.PUBLIC,
    stage = ApiStage.RC)
@ApiVersion(since = "0.0.1", until = "0.0.1")
@ApiAuthNone
@RequestMapping(path = "/books")
@RestController
public class BooksController {

  @ApiMethod
  @GetMapping(path = "{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ApiResponseObject @ResponseBody Book get(
      @ApiPathParam(description = "The name of the city") @PathVariable(value = "name")
          String name) {
    return new Book(name);
  }
}

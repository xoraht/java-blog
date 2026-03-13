package pl.umk.xorahtblog.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PostForm {

    @NotBlank(message = "Tytuł jest wymagany")
    @Size(max = 200, message = "Tytuł może mieć maksymalnie 200 znaków")
    private String title;

    @NotBlank(message = "Treść jest wymagana")
    @Size(max = 5000, message = "Treść może mieć maksymalnie 5000 znaków")
    private String content;

    public String getTitle() { return title; }
    public String getContent() { return content; }

    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
}
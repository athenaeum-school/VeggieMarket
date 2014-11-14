package jp.com.inotaku.domain;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;

public class Authorities {

    @NotNull
    private String authority;

    @NotNull
    private long roleId;

    @NotNull
    @ManyToOne
    private Consumer consumer;
}

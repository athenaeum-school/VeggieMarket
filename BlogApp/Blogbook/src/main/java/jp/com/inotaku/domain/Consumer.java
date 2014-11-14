package jp.com.inotaku.domain;

import javax.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Consumer {

	@Id
    @NotNull
    private String consumerName;

    @NotNull
    private String password;

    private int enabled;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Authorities> authorities = new HashSet<Authorities>();
}

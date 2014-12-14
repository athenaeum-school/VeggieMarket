package jp.com.inotaku.repository;
import jp.com.inotaku.domain.Customer;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Customer.class)
public interface CustomerRepository {
}

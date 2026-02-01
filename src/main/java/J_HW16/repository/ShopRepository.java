package J_HW16.repository;

import J_HW16.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    List<Shop> findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrAddressContainingIgnoreCase(
            String name, String category, String address
    );
}
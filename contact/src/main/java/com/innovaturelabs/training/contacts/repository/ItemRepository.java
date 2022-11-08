package com.innovaturelabs.training.contacts.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.innovaturelabs.training.contacts.entity.Item;
import com.innovaturelabs.training.contacts.view.ItemListView;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    Collection<ItemListView> findAllByUserUserId(Integer userId);

    Optional<Item> findByItemIdAndUserUserId(Integer itemId, Integer userId);

    Item save(Item item);

    Optional<Item> findById(Integer itemId);

    void delete(Item orElseThrow);
}

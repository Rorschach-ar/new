package com.innovaturelabs.training.contacts.service.impl;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovaturelabs.training.contacts.entity.Item;
import com.innovaturelabs.training.contacts.exception.NotFoundException;
import com.innovaturelabs.training.contacts.form.ItemForm;
import com.innovaturelabs.training.contacts.repository.ItemRepository;
import com.innovaturelabs.training.contacts.security.util.SecurityUtil;
import com.innovaturelabs.training.contacts.service.ItemService;
import com.innovaturelabs.training.contacts.view.ItemDetailView;
import com.innovaturelabs.training.contacts.view.ItemListView;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Collection<ItemListView> list() {
        return itemRepository.findAllByUserUserId(SecurityUtil.getCurrentUserId());
    }

    @Override
    public Item add(ItemForm form) {
      
       Item item=new Item(form, SecurityUtil.getCurrentUserId());
       System.out.println(item.getName());
       System.out.println(item.getType());
        Item itemsvd=itemRepository.save(item);
       System.out.println(itemsvd.getType());
       return itemsvd;
    }

    @Override
    public ItemDetailView get(Integer itemId) throws NotFoundException {
        return itemRepository.findByItemIdAndUserUserId(itemId, SecurityUtil.getCurrentUserId())
                .map((item) -> {
                    return new ItemDetailView(item);
                }).orElseThrow(NotFoundException::new);
    }
    @Override
    @Transactional
    public ItemDetailView update(Integer itemId, ItemForm form) throws NotFoundException {
        return itemRepository.findByItemIdAndUserUserId(itemId, SecurityUtil.getCurrentUserId())
                .map((contact) -> {
                    return new ItemDetailView(itemRepository.save(contact.update(form)));
                }).orElseThrow(NotFoundException::new);
    }
    @Override
    @Transactional
    public void delete(Integer itemId) throws NotFoundException {
        itemRepository.delete(
                itemRepository.findById(itemId)
                        .orElseThrow(NotFoundException::new)
        );
    }
}

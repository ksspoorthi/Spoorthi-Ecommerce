package com.niit.trendBackend.Dao;

import java.util.List;

import com.niit.trendBackend.model.Cart;
import com.niit.trendBackend.model.CartItems;

public interface CartItemsDao {
	public boolean saveupdate(CartItems cartItems);// true if succesful else false
	// s returned

public boolean delete(CartItems cartItems);

public CartItems get(String cartitem_id); 

public List<CartItems> list(); 

public List<CartItems> getCartItembyCartId(String cartId);

public CartItems getlistall(String CartId,String pro);


}

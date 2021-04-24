package com.cg.go.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.cg.go.entity.Address;
import com.cg.go.entity.CartItemEntity;
import com.cg.go.entity.Customer;
import com.cg.go.entity.OrderEntity;
import com.cg.go.entity.ProductEntity;
//import com.cg.go.entity.SalesReportEntity;
import com.cg.go.entity.Userdata;
import com.cg.go.entity.WishlistItemEntity;
import com.cg.go.exception.CartException;
import com.cg.go.exception.GrowthReportException;
import com.cg.go.exception.OrderException;
import com.cg.go.exception.ProductException;
import com.cg.go.exception.SalesReportException;
import com.cg.go.exception.WishlistException;
import com.cg.go.service.CartServiceImpl;
import com.cg.go.service.CustomerServiceImpl;
import com.cg.go.service.GrowthReportServiceImpl;
import com.cg.go.service.ICartService;
import com.cg.go.service.ICustomerService;
import com.cg.go.service.IGrowthReportService;
import com.cg.go.service.IOrderService;
import com.cg.go.service.IProductService;
import com.cg.go.service.ISalesReportService;
import com.cg.go.service.IUserService;
import com.cg.go.service.IWishlistService;
import com.cg.go.service.OrderServiceImpl;
import com.cg.go.service.ProductServiceImpl;
import com.cg.go.service.SalesReportServiceImpl;
import com.cg.go.service.UserServiceImpl;
import com.cg.go.service.WishlistServiceImpl;

public class Application {
	public static IUserService userservice = new UserServiceImpl();
	public static ICartService cartservice = new CartServiceImpl();
	public static ICustomerService customerservice = new CustomerServiceImpl();
	public static IGrowthReportService growthReportservice = new GrowthReportServiceImpl();
	public static IOrderService orderservice = new OrderServiceImpl();
	public static IProductService productservice = new ProductServiceImpl();
	public static ISalesReportService salesReportservice = new SalesReportServiceImpl();
	public static IWishlistService wishlistservice = new WishlistServiceImpl();

	public static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Menu[] menus = Menu.values();
		Menu selectedMenu = null;
		while (selectedMenu != Menu.Quit) {
			System.out.println("Choice\tOperation");
			for (Menu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}

			System.out.print("Enter choice : ");
			int ch = scan.nextInt();
			if (ch >= 0 && ch <= menus.length) {
				selectedMenu = menus[ch];

				switch (selectedMenu) {
				case User:
					gouser();
					break;
				case Order:
					goorder();
					break;
				case Cart:
					gocart();
					break;
				case Prdouct:
					goproduct();
					break;
				case Wishlist:
					gowishlist();
					break;
				case Customer:
					gocustomer();
					break;
				case SalesReport:
					gosalesReport();
					break;
				case GrowthReport:
					gogrowthReport();
					break;

				default:
					break;
				}
			} else {
				selectedMenu = null;
			}
		}
	}

	private static void gouser() {
		UserMenu[] menus = UserMenu.values();
		UserMenu selectedMenu = null;

		while (selectedMenu != UserMenu.Quit) {
			System.out.println("Choice\tOperation");
			for (UserMenu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}

			System.out.print("Enter choice : ");
			int ch = scan.nextInt();
			if (ch >= 0 && ch <= menus.length) {
				selectedMenu = menus[ch];

				switch (selectedMenu) {
				case AddUser:
					Adduser();
					break;
				case LoginUser:
					loginuser();
					break;
				case LogoutUser:
					logoutuser();
					break;
				default:
					break;
				}
			} else {
				selectedMenu = null;
			}
		}
	}

	private static void Adduser() {
		Userdata user = new Userdata();
		System.out.println("Enter User Id :");
		user.setUserId(scan.nextInt());
		System.out.println("Enter user Name :");
		user.setUserName(scan.next());
		System.out.println("Enter user type :");
		user.setUserType(scan.next());
		System.out.println("Enter password :");
		user.setUserPassword(scan.next());
		userservice.addUser(user);
		System.out.println("user added");
	}

	private static void loginuser() {
		Userdata user = new Userdata();
		System.out.println("Enter User Id :");
		user.setUserId(scan.nextInt());
		System.out.println("Enter user Name :");
		user.setUserName(scan.next());
		System.out.println("Enter user type :");
		user.setUserType(scan.next());
		System.out.println("Enter password :");
		user.setUserPassword(scan.next());
		userservice.loginUser(user);
	}

	private static void logoutuser() {
		Userdata user = new Userdata();
		System.out.println("Enter User Id :");
		user.setUserId(scan.nextInt());
		System.out.println("Enter user Name :");
		user.setUserName(scan.next());
		System.out.println("Enter user type :");
		user.setUserType(scan.next());
		System.out.println("Enter password :");
		user.setUserPassword(scan.next());
		userservice.logout(user);

	}

	private static void goorder() {
		OrderMenu[] menus = OrderMenu.values();
		OrderMenu selectedMenu = null;

		while (selectedMenu != OrderMenu.Quit) {
			System.out.println("Choice\tOperation");
			for (OrderMenu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}

			System.out.print("Enter choice : ");
			int ch = scan.nextInt();
			if (ch >= 0 && ch <= menus.length) {
				selectedMenu = menus[ch];

				switch (selectedMenu) {
				case findOrdersByUserId:
					dofindOrdersByUserId();
					break;
				case findAllOrders:
					dofindAllOrders();
					break;
				case addOrder:
					goaddorder();
					break;
				case deleteAllOrders:
					dodeleteallorder();
					break;
				case deleteOrderById:
					dodeleteOrderById();
					break;
				case updateDate:
					doupdatedate();
					break;
				default:
					break;
				}
			} else {
				selectedMenu = null;
			}
		}
	}

	private static void dofindOrdersByUserId() {
		OrderEntity order = new OrderEntity();
		System.out.print("Enter order Id :");
		String orderId = scan.next();
		System.out.println("Enter User Id :");
		order.setUserId(scan.next());
		System.out.println("Enter Total price");
		order.setTotalPrice(scan.nextInt());
		System.out.println("Enter total quantity:");
		order.setTotalQuantity(scan.nextInt());
		System.out.println("Enter password :");
		order.setDispatchDate(LocalDate.parse(scan.next()));
		System.out.println("Enter password :");
		order.setDeliveryDate(LocalDate.parse(scan.next()));
		orderservice.findOrdersByUserId(orderId);

	}

	private static void dofindAllOrders() {
		orderservice.findAllOrders();
	}

	private static void goaddorder() {
		OrderEntity order = new OrderEntity();
		System.out.println("Enter order Id :");
		order.setOrderId(scan.next());
		System.out.println("Enter User Id :");
		order.setUserId(scan.next());
		System.out.println("Enter Total price");
		order.setTotalPrice(scan.nextInt());
		System.out.println("Enter total quantity:");
		order.setTotalQuantity(scan.nextInt());
		System.out.println("Enter password :");
		order.setDispatchDate(LocalDate.parse(scan.next()));
		System.out.println("Enter password :");
		order.setDeliveryDate(LocalDate.parse(scan.next()));
		try {
			orderservice.addOrder(order);
			System.out.println("order added");
		} catch (OrderException excep) {
			System.out.println(excep.getMessage());
		}
	}

	private static void dodeleteallorder() {
		try {
			orderservice.deleteAllOrders();
			System.out.println("all order delete");
		} catch (OrderException excep) {
			System.out.println(excep.getMessage());
		}
	}

	private static void dodeleteOrderById() {
		System.out.println("Enter order Id :");
		String orderId = scan.next();
		try {
			orderservice.deleteOrderById(orderId);
			System.out.println("order delete");
		} catch (OrderException excep) {
			System.out.println(excep.getMessage());
		}
	}

	private static void doupdatedate() {
		System.out.println("Enter order Id :");
		String orderId = scan.next();
		System.out.print("Enter User Id :");
		LocalDate dispatchDate = LocalDate.parse(scan.next());
		System.out.print("Enter Total price");
		LocalDate arrivalDate = LocalDate.parse(scan.next());
		try {
			orderservice.updateDate(orderId, dispatchDate, arrivalDate);
			System.out.println("order updated");
		} catch (OrderException excep) {
			System.out.println(excep.getMessage());
		}
	}

	private static void gocart() {
		CartMenu[] menus = CartMenu.values();
		CartMenu selectedMenu = null;

		while (selectedMenu != CartMenu.Quit) {
			System.out.println("Choice\tOperation");
			for (CartMenu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}
			System.out.print("Enter choice : ");
			int ch = scan.nextInt();
			if (ch >= 0 && ch <= menus.length) {
				selectedMenu = menus[ch];

				switch (selectedMenu) {
				case findCartlist:
					dofindCartlist();
					break;
				case findCartItem:
					dofindCartItem();
					break;
				case addCart:
					doaddCart();
					break;
				case updateCart:
					doupdateCart();
					break;
				case deleteCartItem:
					dodeleteCartItem();
					break;
				case deleteCartlist:
					dodeleteCartlist();
					break;
				default:
					break;
				}
			} else {
				selectedMenu = null;
			}
		}
	}

	private static void dofindCartlist() {
		System.out.println("Enter user Id :");
		String userId = scan.next();
		cartservice.findCartlist(userId);
	}

	private static void dofindCartItem() {
		System.out.println("Enter user Id :");
		String userId = scan.next();
		System.out.println("Enter product Id :");
		String productId = scan.next();
		cartservice.findCartItem(productId, userId);
	}

	private static void doaddCart() {
		CartItemEntity cart = new CartItemEntity();
		System.out.println("Enter order Id :");
		cart.setCartId(scan.nextInt());
		System.out.println("Enter User Id :");
		cart.setUserId(scan.next());
		ProductEntity product = new ProductEntity();
		System.out.println("Enter product Id");
		String p = scan.next();
		product.setProductId(p);
		cart.setProducts(product);
		System.out.println("Enter cart total price:");
		cart.setCartTotalPrice(scan.nextInt());
		System.out.println("Enter total quantity :");
		cart.setTotalQuantity(scan.nextLong());
		try {
			cartservice.addCart(cart);
			System.out.println("added to cart");
		} catch (CartException excep) {
			System.out.println(excep.getMessage());
		}
	}

	private static void doupdateCart() {
		CartItemEntity cart = new CartItemEntity();
		System.out.println("Enter cart  Id :");
		cart.setCartId(scan.nextInt());
		System.out.println("Enter User Id :");
		cart.setUserId(scan.next());
		ProductEntity productId = new ProductEntity();
		System.out.println("Enter product id");
		String p = scan.next();
		productId.setProductId(p);
		cart.setProducts(productId);
		System.out.println("Enter Total price:");
		cart.setCartTotalPrice(scan.nextInt());
		System.out.println("Enter password :");
		cart.setTotalQuantity(scan.nextLong());
		try {
			cartservice.updateCart(cart);
			System.out.println("added to cart");
		} catch (CartException excep) {
			System.out.println(excep.getMessage());
		}
	}

	private static void dodeleteCartItem() {
		System.out.println("Enter cart Id :");
		String cartId = scan.next();
		System.out.println("Enter product Id :");
		Long productId = scan.nextLong();
		try {
			cartservice.deleteCartItem(productId, cartId);
			System.out.println("added to cart");
		} catch (CartException excep) {
			System.out.println(excep.getMessage());
		}
	}

	private static void dodeleteCartlist() {
		System.out.println("Enter user Id :");
		String userId = scan.next();
		try {
			cartservice.deleteCartlist(userId);
			System.out.println("added to cart");
		} catch (CartException excep) {
			System.out.println(excep.getMessage());
		}
	}

	private static void goproduct() {
		ProductMenu[] menus = ProductMenu.values();
		ProductMenu selectedMenu = null;

		while (selectedMenu != ProductMenu.Quit) {
			System.out.println("Choice\tOperation");
			for (ProductMenu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}

			System.out.print("Enter choice : ");
			int ch = scan.nextInt();
			if (ch >= 0 && ch <= menus.length) {
				selectedMenu = menus[ch];

				switch (selectedMenu) {
				case findAllProducts:
					dofindAllProducts();
					break;
				case findByProductId:
					dofindByProductId();
					break;
				case findByProductCategory:
					dofindByProductCategory();
					break;
				case addProduct:
					doaddProduct();
					break;
				case updateProduct:
					doupdateProduct();
					break;
				case updateProductQuantity:
					doupdateProductQuantity();
					break;
				case deleteByProductId:
					dodeleteByProductId();
					break;
				case search:
					dosearch();
					break;
				case filter:
					dofilter();
					break;

				default:
					break;
				}
			} else {
				selectedMenu = null;
			}
		}
	}

	private static void dofindAllProducts() {
		productservice.findAllProducts();
	}

	private static void dofindByProductId() {
		System.out.println("Enter product Id :");
		String productId = scan.next();
		productservice.findByProductId(productId);
	}

	private static void dofindByProductCategory() {
		System.out.println("Enter productcategory Id :");
		String productCategory = scan.next();
		productservice.findByProductCategory(productCategory);
	}

	private static void doaddProduct() {
		ProductEntity product = new ProductEntity();
		System.out.println("Enter product Id :");
		product.setProductId(scan.next());
		System.out.println("Enter product name :");
		product.setProductName(scan.next());
		System.out.println("Enter price");
		product.setPrice(scan.nextDouble());
		System.out.println("Enter image:");
		product.setImage(scan.next());
		System.out.println("Enter color :");
		product.setColor(scan.next());
		System.out.println("Enter category :");
		product.setCategory(scan.next());
		System.out.println("Enter Quantity :");
		product.setQuantity(scan.nextInt());
		System.out.println("Enter manufacture :");
		product.setManufacturer(scan.next());
		System.out.println("Enter specification :");
		product.setSpecification(scan.next());
		try {
			productservice.addProduct(product);
			System.out.println("added to cart");
		} catch (ProductException excep) {
			System.out.println(excep.getMessage());
		}

	}

	private static void doupdateProduct() {
		ProductEntity product = new ProductEntity();
		System.out.println("Enter product Id :");
		product.setProductId(scan.next());
		System.out.println("Enter product name :");
		product.setProductName(scan.next());
		System.out.println("Enter price");
		product.setPrice(scan.nextDouble());
		System.out.println("Enter image:");
		product.setImage(scan.next());
		System.out.println("Enter color :");
		product.setColor(scan.next());
		System.out.println("Enter category :");
		product.setCategory(scan.next());
		System.out.println("Enter Quantity :");
		product.setQuantity(scan.nextInt());
		System.out.println("Enter manufacture :");
		product.setManufacturer(scan.next());
		System.out.println("Enter specification :");
		product.setSpecification(scan.next());
		try {
			productservice.updateProduct(product);
			System.out.println("added to cart");
		} catch (ProductException excep) {
			System.out.println(excep.getMessage());
		}
	}

	private static void doupdateProductQuantity() {
		System.out.println("Enter product Id :");
		String productId = scan.next();
		System.out.println("Enter quantity :");
		Integer quantity = scan.nextInt();
		productservice.updateProductQuantity(quantity, productId);
	}

	private static void dodeleteByProductId() {
		System.out.println("Enter product Id :");
		String productId = scan.next();
		try {
			productservice.deleteByProductId(productId);
			System.out.println("added to cart");
		} catch (ProductException excep) {
			System.out.println(excep.getMessage());
		}
	}

	private static void dosearch() {
		System.out.println("Enter product Id :");
		String keyword = scan.next();
		productservice.search(keyword);
	}

	private static void dofilter() {
		System.out.println("Enter product Id :");
		double maxprice = scan.nextDouble();
		productservice.filter(maxprice);
	}

	private static void gowishlist() {
		WishListMenu[] menus = WishListMenu.values();
		WishListMenu selectedMenu = null;

		while (selectedMenu != WishListMenu.Quit) {
			System.out.println("Choice\tOperation");
			for (WishListMenu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}
			System.out.print("Enter choice : ");
			int ch = scan.nextInt();
			if (ch >= 0 && ch <= menus.length) {
				selectedMenu = menus[ch];
				switch (selectedMenu) {
				case findAllItems:
					dofindAllItems();
					break;
				case findWishlist:
					dofindWishlist();
					break;
				case findWishlistItem:
					dofindWishlistItem();
					break;
				case addProductToWishlist:
					doaddProductToWishlist();
					break;
				case deleteWishlistItem:
					dodeleteWishlistItem();
					break;
				case deleteWishlist:
					dodeleteWishlist();
					break;
				case addWishlistItem:
					doaddWishlistItem();
					break;

				default:
					break;
				}
			} else {
				selectedMenu = null;
			}
		}
	}

	private static void dofindAllItems() {
		wishlistservice.findAllItems();
	}

	private static void dofindWishlist() {
		System.out.println("enter the user id");
		String userId = scan.next();
		wishlistservice.findWishlist(userId);

	}

	private static void dofindWishlistItem() {
		System.out.println("enter the user id");
		String userId = scan.next();
		System.out.println("enter the product  id");
		String productId = scan.next();
		wishlistservice.findWishlistItem(productId, userId);
	}

	private static void doaddProductToWishlist() {
		System.out.println("enter the user id");
		String productId = scan.next();
		System.out.println("enter the product  id");
		long WishlistId = scan.nextLong();
		wishlistservice.addProductToWishlist(productId, WishlistId);
	}

	private static void dodeleteWishlistItem() {
		System.out.println("enter the user id");
		String userId = scan.next();
		System.out.println("enter the product  id");
		String productId = scan.next();
		try {
			wishlistservice.deleteWishlistItem(productId, userId);
			System.out.println("added to cart");
		} catch (WishlistException excep) {
			System.out.println(excep.getMessage());
		}
	}

	private static void dodeleteWishlist() {
		System.out.println("enter the user id");
		String userId = scan.next();
		try {
			wishlistservice.deleteWishlist(userId);
			System.out.println("added to cart");
		} catch (WishlistException excep) {
			System.out.println(excep.getMessage());
		}
	}

	private static void doaddWishlistItem() {
		WishlistItemEntity wishlist = new WishlistItemEntity();
		System.out.println("Enter order Id :");
		wishlist.setWishlistId(scan.nextLong());
		System.out.println("Enter User Id :");
		wishlist.setUserId(scan.next());
		System.out.println("Enter Total price");
		wishlist.setProductId(null);
	}

	private static void gocustomer() {
		CustomerMenu[] menus = CustomerMenu.values();
		CustomerMenu selectedMenu = null;

		while (selectedMenu != CustomerMenu.Quit) {
			System.out.println("Choice\tOperation");
			for (CustomerMenu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}

			System.out.print("Enter choice : ");
			int ch = scan.nextInt();
			if (ch >= 0 && ch <= menus.length) {
				selectedMenu = menus[ch];

				switch (selectedMenu) {
				case getAllCustomers:
					dogetAllCustomers();
					break;
				case addCustomer:
					doaddCustomer();
					break;
				case updateCustomer:
					doupdateCustomer();
					break;
				case removeCustomer:
					doremoveCustomer();
					break;
				case viewCustomer:
					doviewCustomer();
					break;
				default:
					break;
				}
			} else {
				selectedMenu = null;
			}
		}
	}

	private static void dogetAllCustomers() {
		customerservice.getAllCustomers();
	}

	private static void doaddCustomer() {
		Customer customer = new Customer();
		System.out.println("Enter order Id :");
		customer.setCustomerId(scan.nextInt());
		System.out.println("Enter User Id :");
		customer.setCustomerName(scan.next());
		System.out.println("Enter product Id");
		customer.setMobileNo(scan.next());
		System.out.println("Enter cart total price:");
		customer.setEmail(scan.next());
		Address address = new Address();
		System.out.println("Enter the address Id :");
		String addressId = scan.next();
		address.setAddressId(addressId);
		customer.setAddress(address);
		System.out.println("Enter the address Id :");
		customer.setRole(scan.next());
		customerservice.addCustomer(customer);
	}

	private static void doupdateCustomer() {
		Customer customer = new Customer();
		System.out.println("Enter order Id :");
		customer.setCustomerId(scan.nextInt());
		System.out.println("Enter User Id :");
		customer.setCustomerName(scan.next());
		System.out.println("Enter product Id");
		customer.setMobileNo(scan.next());
		System.out.println("Enter cart total price:");
		customer.setEmail(scan.next());
		Address address = new Address();
		System.out.println("Enter the address Id :");
		String addressId = scan.next();
		address.setAddressId(addressId);
		customer.setAddress(address);
		System.out.println("Enter the address Id :");
		customer.setRole(scan.next());
		customerservice.updateCustomer(customer);
	}

	private static void doremoveCustomer() {
		Customer customer = new Customer();
		System.out.println("Enter order Id :");
		customer.setCustomerId(scan.nextInt());
		customerservice.removeCustomer(customer);
	}

	private static void doviewCustomer() {
		Customer customer = new Customer();
		System.out.println("Enter order Id :");
		customer.setCustomerId(scan.nextInt());
		customerservice.viewCustomer(customer);
	}

	private static void gosalesReport() {
		SalesReportMenu[] menus = SalesReportMenu.values();
		SalesReportMenu selectedMenu = null;

		while (selectedMenu != SalesReportMenu.Quit) {
			System.out.println("Choice\tOperation");
			for (SalesReportMenu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}
			System.out.print("Enter choice : ");
			int ch = scan.nextInt();
			if (ch >= 0 && ch <= menus.length) {
				selectedMenu = menus[ch];

				switch (selectedMenu) {
				
				case updateProductReport:
					doupdateProductReport();
					break;
			
				case findSalesReportByProductId:
					dofindSalesReportByProductId();
					break;
				
				case existsByProductId:
					doexistsByProductId();
					break;
					
				default:
					break;
				}
			} else {
				selectedMenu = null;
			}
		}
	}


	private static void doexistsByProductId() {
		System.out.println("enter product Id");
		String productId = scan.next();
		salesReportservice.existsByProductId(productId);
	}

	private static void dofindSalesReportByProductId() {
		System.out.println("enter product Id");
		String productId = scan.next();
		salesReportservice.findByProductId(productId);
	}

	private static void doupdateProductReport() {
		System.out.println("Enter the product Id");
		String productId = scan.next();
		System.out.println("Enter the quantity sold ");
		Integer quantitysold= scan.nextInt();
		System.out.println("Enter the total sale");
		double totalsale=scan.nextDouble();
		salesReportservice.updateProductReport(productId, quantitysold, totalsale);

	}



	private static void gogrowthReport() {
		GrowthReportMenu[] menus = GrowthReportMenu.values();
		GrowthReportMenu selectedMenu = null;
		while (selectedMenu != GrowthReportMenu.Quit) {
			System.out.println("Choice\tOperation");
			for (GrowthReportMenu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}
			System.out.print("Enter choice : ");
			int ch = scan.nextInt();
			if (ch >= 0 && ch <= menus.length) {
				selectedMenu = menus[ch];

				switch (selectedMenu) {
				case findAllGrowthReport:
					dofindAllGrowthReport();
					break;
				case addGrowthReport:
					doaddGrowthReport();
					break;
				case deleteAllGrowthReport:
					dodeleteAllGrowthReport();
					break;
				case deleteGrowthReportById:
					deleteGrowthReportById();
					break;

				default:
					break;
				}
			} else {
				selectedMenu = null;
			}
		}
	}

	private static void dofindAllGrowthReport() {
		growthReportservice.findAllGrowthReport();
	}

	private static void doaddGrowthReport() {
		try {
			growthReportservice.addGrowthReport();
		} catch (SalesReportException excep) {
			System.out.println(excep.getMessage());
		}
	}

	private static void dodeleteAllGrowthReport() {
		try {
			growthReportservice.deleteAllGrowthReport();
		} catch (GrowthReportException excep) {
			System.out.println(excep.getMessage());
		}
	}

	private static void deleteGrowthReportById() {
		System.out.println("enter GrowthreportId Id");
		Long GrowthreportId = scan.nextLong();
		try {
			growthReportservice.deleteGrowthReportById(GrowthreportId);
		} catch (GrowthReportException excep) {
			System.out.println(excep.getMessage());
		}
	}
}

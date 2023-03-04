Feature: Como usuario
  Yo quiero realizar compras en la pagina de Falabella

  Scenario Outline: Compra exitosa
    #Given que el usuario se encuentra ubicado en la pagina de google usando el <navegador>
    Given que el usuario se encuentra en la pagina de google
    When el usuario ingrese la palabra falabella en el campo de busqueda
    And el usuario seleccione la tienda de colombia
    And el usuario consulte un producto <producto>
    And el usuario seleccione el producto <producto>
    And el usuario agregue el producto al carro de compras
    And el usuario elija la <garantia>
    And el usuario aumente la cantidad del producto
    And el usuario seleccione la opcion ir a comprar
    Then el sistema presenta el resumen de la orden en la siguiente url https://www.falabella.com.co/falabella-co/checkout/delivery
    Examples:
      | producto                                        | garantia |
      | Nevera Samsung Congelador Superior No Frost 380 | 2        |

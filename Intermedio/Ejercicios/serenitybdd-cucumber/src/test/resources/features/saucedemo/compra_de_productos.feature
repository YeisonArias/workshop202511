Feature: Compra de productos
  Como usuario de SauceDemo
  Quiero comprar productos
  Para realizar compras

  @Test
  Scenario: Comprar 2 productos
    Given que el usuario esta en la pagina de login de SauceDemo
    When el usuario ingresa las credenciales
    And agrega dos productos al carrito
    And procede al checkout completando la información requerida
    Then debe visualizar el mensaje de confirmación "Thank you for your order!"
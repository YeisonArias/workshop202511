Feature: Login SauceDemo
  Como usuario de SauceDemo
  Quiero iniciar sesión
  Para realizar compras

  @Test
  Scenario: Login Exitoso SauceDemo
    Given que el usuario esta en la pagina de login de SauceDemo
    When el usuario ingresa las credenciales
    Then el usuario es redirigido a la pagina de Swag Labs



# language: es
# Tags: @CatBreeds
# Author : alejoil777@gmail.com
Característica: Consulta general de razas de gatos
  Como usuario de los servicios del API-REST de Cat API
  Quiero consultar la información de todas las razas de gatos
  Para tener estar actualizado y poder hacer consultas más espcíficas a partir de ésta información

  @CatBreeds
  Escenario: Consulta general de razas de gatos
    Dado que Adrian es un cliente activo en el API-REST de Geonames
    Cuando él realice la consulta de las razas de gatos sin filtros
    Entonces él debe ver la información detallada de las razas de gatos consultadas
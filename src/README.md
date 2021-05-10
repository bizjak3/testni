# Pasjehodec - implementacija storitve

[![GitHub Actions testiranje](https://github.com/tpo-2020-2021/LP234-15/actions/workflows/main.yml/badge.svg?branch=master)](https://github.com/tpo-2020-2021/LP234-15/actions/workflows/main.yml)

> Produkcijska različica je na voljo na [pasjehodec.marela.team](pasjehodec.marela.team).

## Lokalni razvoj

Za lokalni razvoj je potrebna naslednja lokalno nameščena programska oprema:

- nodejs, npm in AngularCLI (zadnje verzije, 10.05.2021)
- mvn (zadnja verzija, 10.05.2021)
- Java 15 ali višja
- Docker in docker-compose
- (ali) nameščen Redis in MariaDB strežnik

Za poganjanje baz je dovolj, da znotraj mape `/src` zaženemo ukaz:

```
docker-compose up
```

Za poganjanje čelnega dela v mapi `/src/frontend` poženemo:

```
npm install
ng serve
```

Za poganjanje zalednega dela pa v mapi `src/backend`:

```
mvn clean package
java -jar /target/*.jar

```

### Lokalno poganjanje avtomatskih testov

Avtomatski testi se izvajajo na čelnem in zalednem delu aplikacije, na zalednem delu jih poganjamo v mapi `/src/backend` z ukazom `mvn test`. Na zelednem delu pa znotraj mape `/src/` z ukazoma:

```
docker-compose up
cd frontend
ngx run cypress
```

## Podatki za dostop do produkcijske aplikacije

V aplikaciji obstajajo tri vrste registriranih uporabnikov:

- administrator
- lastnik psa
- izvajalec storitev

V nadaljevanju navajamo podatke za prijavo:
| Vrsta uporabnika | Uporabniško ime | Geslo |
|----|----|----|
|administrator| admin| admin |
|lastnik psa | lastnik | lastnik |
|izvajalec storitev | pinkop | pinkop |

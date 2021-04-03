# Dokument zahtev

|                             |                                                         |
| :-------------------------- | :------------------------------------------------------ |
| **Naziv projekta**          | **TO-DO** naziv projekta                                |
| **Člani projektne skupine** | **TO-DO** 1. član, 2. član, 3. član, 4. član in 5. član |
| **Kraj in datum**           | **TO-DO** kraj, datum                                   |

## Povzetek projekta

**TO-DO**

- Povzetek je, kot že vemo, celoten dokument, strnjen v največ 150 besed.

## 1. Uvod

**TO-DO**

- V uvodu opišite problemsko domeno (kateri problem bo naša aplikacija reševala) in kratek pregled glavnih funkcionalnosti (kaj vse bo aplikacija počela).

## 2. Uporabniške vloge

**TO-DO**

- Opredelite glavne tipe uporabnikov vaše aplikacije glede na funkcionalnosti, ki jih imajo na voljo.
- Zelo pomembno je, da uporabniške vloge konsistentno imenujete. Na primer, če ste definirali vlogo **učitelj**, morate povsod uporabljati samostalnik **učitelj**, ne pa morda **profesor** ali **pedagog**. Tehniška besedila žal ne morejo dosegati leposlovnih standardov, tudi če so še tako dobro napisana.

1. Lastnik psa
2. Izvajalec storitev
3. Administrator sistema (ali administrator)
4.
5.

## 3. Slovar pojmov

**TO-DO**

- Natančno opredelite vse têrmine, ki jih boste uporabljali v nadaljevanju dokumenta.

**Lastnik psa** je oseba, ki se v aplikacijo prijavlja z namenom oddaje lastnega psa v izvedbo katere izmed storitev, ki jo aplikacija ponuja.

**Izvajalaec storitve** je oseba, ki se v aplikacijo prijavlja z namenom izvajanja ene izmed storitev, ki jo aplikacija ponuja.

**Administrator sistema** _(ali administrator)_ je oseba, ki se v aplikacijo prijavlja z namenom upravljanja in nadzora delovanja aplikacije.

**Uporabnik** je oseba, ki aplikacijo uporablja. Vsak uporabnik ima določeno uporabniško vlogo definirano v _2. Uporabniške vloge_.

**Neregistriran uporabnik** je uporabnik, ki še ni opravil ali zaključil postopka registracije. **Registriran uporabnik** je uporabnik, ki je upešno zaključil postopek registracije.

**Povratna informacija** je avdio-vizualni element v aplikaciji, ki z besedilom, zvokom ali sliko uporabnika obvesti o rezultetu izvedene akcije.

Uporabniško ime, email, geslo

## 4. Diagram primerov uporabe

**TO-DO**

- Narišite diagram primerov uporabe v jeziku UML.
- Diagram predstavlja interakcijo med akterji in funkcionalnostmi (kdo lahko kaj počne).
- Akterji so tipično uporabniške vloge, lahko pa gre tudi za zunanje komponente (sistemi), ki komunicirajo z našo aplikacijo.

![alt text](../img/uml_diagram.png)

## 5. Funkcionalne zahteve

Seznam funkcionalnosti:

1. Registracija lastnika psa ali izvajalca storitve (MUST)
2. Prijava uporabnika (MUST)
3. Pregled vseh ponujenih storitev v okviru aplikacije (MUST)
4. Dodajanje nove ponudbe storitve kot izvajalec storitve (MUST)
5. Dodajanje novega psa z njegovimi lastnostmi kot lastnik psa (COULD)
6. Kopiranje vsebine pretečene storitve v novo storitev, kot izvajalec storitev (COULD)
7. Pregled in urejanje podatkov uporabnika kot administrator sistema (SHOULD)
8. Pregled in urejanje podatkov prijavljenega uporabnika, pregled javnih podatkov uporabnika (SHOULD)
9. Izvajanje plačila za opravljeno storitev znotraj aplikacije (WONT)
10. Pregled lokacije psa v posestvi lastnika psa v času izvajanja storitve izvajalca storitve (WONT)
11. Neposredna komunikacija med izvajalcem storitve in lastnika psa (COULD)
12. Ocenjevanje opravljene storitve izvajalca storitev (SHOULD)
13. Pregled izvedenih storitev prijavljenega uporabnika (COULD)

V tem razdelku podrobno opišite posamezne funkcionalnosti, ki jih vaša aplikacija ponuja svojim uporabnikom. Za vsako funkcionalnost navedite naslednje podatke:

### 5.1 Registracija lastnika psa ali ponudnika storitve

#### Povzetek funkcionalnosti

Lastnik psa ali izvajalec storitev se lahko registrira v sistem. V sistem se lahko z enakimi podatki registrira samo enkrat kot lastnik psa in enkrat kot izvajalec storitve.

#### Osnovni tok

1. Na začetni strani neregistriran uporabnik izbere možnost "Registracija novega lastnika psa" ali "Registracija novega ponudnika storitev"
2. Sistem prikaže obrazev, v katerega neregistriran uporabnik vnese vse potrebne podatke za registracijo.
3. Uporabnik, po vnosu podatkov, izbere gumb "Registracija"
4. Sistem shrani podatke v bazo in generira edinstven registracijski žeton, ki je uporabniku posredovan na vnešen epoštni naslov.
5. Neregistriran uporabnik v poslanem epoštnem sporočilu izbere možnost "Zaključi registracijo".
6. Uporabnik je preusmerjen na začetno stran s povratno informacijo o uspešnem zaključku registracije.

#### Alternativni tok(ovi)

**Alternativni tok 1**

1. Neregistriran uporabnik na začetni strani izbere "Prijava"
2. Na novoodprti strani uporabnik izbere možnost "Nisem še registriran, registriraj me sedaj"
3. Sistem prikaže obrazec, v katerega neregistriran uporabnik vnese vse potrebne podatke za registracijo.
4. Uporabnik, po vnosu podatkov, izbere gumb "Registracija"
5. Sistem shrani podatke v bazo in generira edinstven registracijski žeton, ki je uporabniku posredovan na vnešen epoštni naslov.
6. Neregistriran uporabnik v poslanem epoštnem sporočilu izbere možnost "Zaključi registracijo".
7. Uporabnik je preusmerjen na začetno stran s povratno informacijo o uspešnem zaključku registracije.

#### Izjemni tok(ovi)

- Uporabnik ni vnesel vseh potrebnih podatkov. Sistem javi napako.
- Uporabnik se je z istimi podatki že registriral. Sistem javi napako in ga preusmeri na prijavno stran.
- Uporabnik vnese enake podatke kot nek drugi uporabnik za podatke, ki morajo biti edinstveni na glede na zahteve informacijskega sistema. Sistem javi napako.

#### Pogoji

V sistemu ne sme obstajati uporabnik z enakimi podatki, ki morajo biti v sistemu edinstveni - uporabniško ime, email.

#### Posledice

Neregistriran uporabnik se je registriral v sistem kot lastnik psa ali kot ponudnik storitve ter s tem postal registriran uporabnik.

#### Posebnosti

Funkcionalna zahteva ne zahteva nikakršnih programskih ali strojnih posebnosti.

#### Prioritete identificiranih funkcionalnosti

Funkacionalnost je po metodi _MoSCoW_ označena kot _must have_.

#### Sprejemni testi

- Neregistriran uporabnik se v sistem registrira kot nov uporabnik tipa lastnik psov z novimi (edinstvenimi) podatki.
- Neregistriran uporabnik se v sistem registrira kot nov uporabnik tipa lastnik psov z needinstvenimi podatki. Registracija je zavrnjena.
- Neregistriran uporabnik se v sistem registrira kot nov uporabnik tipa ponudnik storitev z z needinstvenimi podatki. Registracija je zavrnjena.

### 5.2 Prijava uporabnika

#### Povzetek funkcionalnosti

Registriran uporabnik kateregakoli tipa se lahko prijavi v sistem z uporabniškim imenom in geslom.

#### Osnovni tok

1. Na začetni strani registriran uporabnik izbere možnost "Prijava uporabnika"
2. Sistem prikaže obrazec, v katerega uporabnik vnese uporabniško ime ali epoštni naslov.
3. Uporabnik, po vnosu podatkov, izbere gumb "Prijava"
4. Ob pravilno vnešenih podatkih je uporabnik prijavljen v aplikacijo s povratno informacijo.

#### Alternativni tok(ovi)

**Alternativni tok 1**

1. Uporabnik na začetni strani izbere "Registracija novega lastnika psa" ali "Registracija novega ponudnika storitev"
2. Na novoodprti strani uporabnik izbere možnost "Registracijo sem že opravil, prijavi me"
3. Sistem prikaže obrazec, v katerega uporabnik vnese uporabniško ime ali epoštni naslov.
4. Uporabnik, po vnosu podatkov, izbere gumb "Prijava"
5. Ob pravilno vnešenih podatkih je uporabnik prijavljen v aplikacijo s povratno informacijo.

#### Izjemni tok(ovi)

- Uporabnik ni vnesel pravilne kombinacije uporabniškega imena in gesla ali emaila in gesla. Sistem ga opozoril s povratno informacijo.
- Uporabnik z vnešenim uporabniškim imenom ali epošto v sistemu ne obstaja. Sistem uporabnika opozoril s povratno informacijo.

#### Pogoji

V sistemu mora obstaja registriran uporabnik z enako kombinacijo epošte in gesla ali uporabniškega imena in gesla.

#### Posledice

Registriran uporabnik se je prijavil v sistem kot uporabnik z določeno uporabniško vlogo.

#### Posebnosti

Funkcionalna zahteva ne zahteva nikakršnih programskih ali strojnih posebnosti.

#### Prioritete identificiranih funkcionalnosti

Funkacionalnost je po metodi _MoSCoW_ označena kot _must have_.

#### Sprejemni testi

- Uporabnik se uspešno prijavi z ustrezno kombinacijo uporabniškega imena in gesla.
- Uporabnik se uspešno prijavi z ustrezno kombinacijo emaila in gesla.
- Uporabnik se neuspešno prijavi z neustrezno kombinacijo uporabniškega imena in gesla. Prijava je zavrnjena.
- Uporabnik se neuspešno prijavi z neustrezno kombinacijo emaila in gesla. Prijava je zavrnjena.

### 5.3 Pregled vseh ponujenih storitev v okviru aplikacije

#### Povzetek funkcionalnosti

Prijavljen uporabnik lahko pregleduje vse ponujene objavljene storitve.

#### Osnovni tok

1. Uporabnik mora biti prijavljen v aplikacijo.
2. Po uspešni prijavi uporabnika sistem preusmeri na seznam vseh ponujenih storitev.

#### Alternativni tok(ovi)

Funkcionalna zahteva nima alternativnih tokov.

#### Izjemni tok(ovi)

- V kolikor v aplikaciji ni objavljenih ponujenih storitev sistem vrne obvestilo "V sistemu ni trenutno aktivnih storitev".

#### Pogoji

Uporabnik mora biti uspešno prijavljen v sistem.

#### Posledice

Uporabnik lahko pregleduje vse objavljene ponujene storitve v okviru aplikacije.

#### Posebnosti

Funkcionalna zahteva ne zahteva nikakršnih programskih ali strojnih posebnosti.

#### Prioritete identificiranih funkcionalnosti

Funkacionalnost je po metodi _MoSCoW_ označena kot _must have_.

#### Sprejemni testi

- Uporabniku se po uspšeni prijavi prikažejo ponujene storitve ali napis "V sistemu ni trenutno aktivnih storitev"
















### 5.4 Dodajanje nove ponudbe storitve kot izvajalec storitve

#### Povzetek funkcionalnosti

Izvajalec storitve lahko doda novo storitev v sistem.

#### Osnovni tok

1. Uporabnik mora biti prijavljen v aplikacijo kot izvajalec storitev. Po uspešni prijavi uporabnika sistem preusmeri na seznam vseh ponujenih storitev.
2. Uporabnik izbere gumb "Dodaj novo storitev".
3. V novo odprtem oknu uporabnik vnese vse potrebne podatke ter storitev potrdi s pritiskom gumba "Oddaj ponudbo".
4. Ob pravilnem vnosu je ponujena storitev potrjena s povratno informacijo in objavljena na seznamu vseh ponujenih storitev.

#### Alternativni tok(ovi)

**Alternativni tok 1**
1.  Uporabnik mora biti prijavljen v aplikacijo kot izvajalec storitev. Po uspešni prijavi uporabnika sistem preusmeri na seznam vseh ponujenih storitev.
2. Uporabnik izbere možnost ogleda lastnega profila
3. Na profilu, v razdelku "Moje storitve" izbere možnost "Dodaj novo storitev"
4. V novo odprtem oknu uporabnik vnese vse potrebne podatke ter storitev potrdi s pritiskom gumba "Oddaj ponudbo".
5. Ob pravilnem vnosu je ponujena storitev potrjena s povratno informacijo in objavljena na seznamu vseh ponujenih storitev.

#### Izjemni tok(ovi)

- Če uporabnik nima uporabniške vloge izvajalec storitev, nove storitve ne more dodati.
- Če izvajalec storitve ne vnese vseh potrebnih podatkov, ga sistem opozori s povratno informacijo.

#### Pogoji

Uporabnik mora biti uspešno prijavljen v sistem. Uporabnik mora imeti uporabniško vlogo izvajalec storitev.

#### Posledice

V sistem je vnešena nova storitev.

#### Posebnosti

Funkcionalna zahteva ne zahteva nikakršnih programskih ali strojnih posebnosti.

#### Prioritete identificiranih funkcionalnosti

Funkacionalnost je po metodi _MoSCoW_ označena kot _must have_.

#### Sprejemni testi

- Izvajalec storitev ob vnosu vseh potrebnih podatkov v sistem doda novo storitev.


### 5.5 Dodajanje novega psa z njegovimi lastnostmi kot lastnik psa

#### Povzetek funkcionalnosti

Prijavljen uporabnik z uporabniško vlogo lastnik psov lahko doda novega psa z njegovimi lastnostmi

#### Osnovni tok

1. Uporabnik mora biti prijavljen v aplikacijo kot lastnik psov. Po uspešni prijavi uporabnika sistem preusmeri na seznam vseh ponujenih storitev.
2. Uporabnik izbere gumb "Dodaj novega psa".
3. V novo odprtem oknu uporabnik vnese vse potrebne podatke ter psa potrdi s pritiskom gumba "Dodaj štirinožca".
4. Ob pravilnem vnosu je dodan pes potrjena s povratno informacijo in dodan na seznam lastnih psov.

#### Alternativni tok(ovi)

**Alternativni tok 1**
1.  Uporabnik mora biti prijavljen v aplikacijo kot lastnik psov. Po uspešni prijavi uporabnika sistem preusmeri na seznam vseh ponujenih storitev.
2. Uporabnik izbere možnost ogleda lastnega profila
3. Na profilu, v razdelku "Moje štirinožni prijatelji" izbere možnost "Dodaj novega štirinožca"
4. V novo odprtem oknu uporabnik vnese vse potrebne podatke ter storitev potrdi s pritiskom gumba "Dodaj štirinožca".
5. Ob pravilnem vnosu je dodan pes potrjena s povratno informacijo in dodan na seznam lastnih psov.

#### Izjemni tok(ovi)

- Če uporabnik nima uporabniške vloge lastnik psov, novega psa ne more dodati.
- Če lastnik psov ne vnese vseh potrebnih podatkov, ga sistem opozori s povratno informacijo.

#### Pogoji

Uporabnik mora biti uspešno prijavljen v sistem. Uporabnik mora imeti uporabniško vlogo lastnik psov.

#### Posledice

V sistem je vnešen nov pes.

#### Posebnosti

Funkcionalna zahteva ne zahteva nikakršnih programskih ali strojnih posebnosti.

#### Prioritete identificiranih funkcionalnosti

Funkacionalnost je po metodi _MoSCoW_ označena kot _could have_.

#### Sprejemni testi

- Izvajalec storitev ob vnosu vseh potrebnih podatkov v sistem doda novega psa.

### 5.6 Kopiranje vsebine pretečene storitve v novo storitev, kot izvajalec storitev

#### Povzetek funkcionalnosti

Prijavljen uporabnik z uporabniško vlogo izvajalec storitev lahko med lastnimi preteklimi storitvami izbere eno ter jo kopira v novo storitev z nekoliko spremenjenimi podatki.

#### Osnovni tok

1. Uporabnik mora biti prijavljen v aplikacijo kot izvajalec storitev. Po uspešni prijavi uporabnika sistem preusmeri na seznam vseh ponujenih storitev.
2. Uporabnik izbere možnost ogleda lastnega profila
3. Na profilu, v razdelku "Moje storitve" izbere storitev, ki jo želi kopirati
4. V novem oknu izbere možnost "Kopiranje vsebine v novo storitev"
5. V novem oknu spremeni željene podatke in jih potrdi s "Dodaj storitev"
6. Storitev je shranjena s povratno informacijo.

#### Alternativni tok(ovi)

Funkcionalnost ne predvideva alternativnih tokov.

#### Izjemni tok(ovi)

- Če uporabnik nima uporabniške vloge ponudnik storitev, operacije kopiranja storitev ne more izvesti.
- Če uporabnik nima zgodovine dodanih storitev, operacije ne more izvesti.

#### Pogoji

Uporabnik mora biti uspešno prijavljen v sistem. Uporabnik mora imeti uporabniško vlogo ponudnik storitev. Uporabnik mora imet zgodovino dodanih storitev.

#### Posledice

V sistem je vnešena nova storitev.

#### Posebnosti

Funkcionalna zahteva ne zahteva nikakršnih programskih ali strojnih posebnosti.

#### Prioritete identificiranih funkcionalnosti

Funkacionalnost je po metodi _MoSCoW_ označena kot _could have_.

#### Sprejemni testi

- Izvajalec storitev ob vnosu vseh potrebnih podatkov v sistem doda novega psa.


### 5.7 Pregled in urejanje podatkov uporabnika kot administrator sistema

------- TUKAJ NADALJUJ -------

#### Povzetek funkcionalnosti

Prijavljen uporabnik z uporabniško vlogo izvajalec storitev lahko med lastnimi preteklimi storitvami izbere eno ter jo kopira v novo storitev z nekoliko spremenjenimi podatki.

#### Osnovni tok

1. Uporabnik mora biti prijavljen v aplikacijo kot izvajalec storitev. Po uspešni prijavi uporabnika sistem preusmeri na seznam vseh ponujenih storitev.
2. Uporabnik izbere možnost ogleda lastnega profila
3. Na profilu, v razdelku "Moje storitve" izbere storitev, ki jo želi kopirati
4. V novem oknu izbere možnost "Kopiranje vsebine v novo storitev"
5. V novem oknu spremeni željene podatke in jih potrdi s "Dodaj storitev"
6. Storitev je shranjena s povratno informacijo.

#### Alternativni tok(ovi)

Funkcionalnost ne predvideva alternativnih tokov.

#### Izjemni tok(ovi)

- Če uporabnik nima uporabniške vloge ponudnik storitev, operacije kopiranja storitev ne more izvesti.
- Če uporabnik nima zgodovine dodanih storitev, operacije ne more izvesti.

#### Pogoji

Uporabnik mora biti uspešno prijavljen v sistem. Uporabnik mora imeti uporabniško vlogo ponudnik storitev. Uporabnik mora imet zgodovino dodanih storitev.

#### Posledice

V sistem je vnešena nova storitev.

#### Posebnosti

Funkcionalna zahteva ne zahteva nikakršnih programskih ali strojnih posebnosti.

#### Prioritete identificiranih funkcionalnosti

Funkacionalnost je po metodi _MoSCoW_ označena kot _could have_.

#### Sprejemni testi

- Izvajalec storitev ob vnosu vseh potrebnih podatkov v sistem doda novega psa.


### TO-DO Naziv zahteve

#### Povzetek funkcionalnosti

**TO-DO**

- **Povzetek funkcionalnosti** v enem ali največ nekaj stavkih.
- Prvi stavek naj se prične z nazivom uporabniške vloge (ali uporabniških vlog, če se funkcionalnost nanaša na več kot eno vlogo), nato pa naj sledita beseda **lahko** in navedba funkcionalnosti.

#### Osnovni tok

**TO-DO**

#### Alternativni tok(ovi)

**TO-DO**

- Navesti je potrebno vse alternativne tokove, ki jih označite kot **Alternativni tok 1**, **Alternativni tok 2**, itd.

#### Izjemni tok(ovi)

#### Pogoji

**TO-DO**

- Navesti je potrebno pogoje, ki morajo biti izpolnjeni, da se funkcionalnost lahko prične izvajati?

#### Posledice

**TO-DO**

- Navedite, kakšen je rezultat izvedbe osnovnega toka funkcionalnosti?

#### Posebnosti

**TO-DO**

- Ali realizacija funkcionalnosti zahteva kakšne posebnosti, kot je npr. dodatna strojna oprema?
- Se je potrebno držati kakšnih posebnih standardov?

#### Prioritete identificiranih funkcionalnosti

**TO-DO**

- Za identificirane funkcionalnosti se z metodo **MoSCoW** (MUST have, SHOULD have, COULD have in WOULD have) določi prioritete.

#### Sprejemni testi

**TO-DO**

- Navedite sprejmne teste, kjer opišete:
  - funkcijo, ki se testira,
  - začetno stanje sistema,
  - vhod in
  - pričakovan rezultat.

## 6. Nefunkcionalne zahteve

**TO-DO**

- Navedite splošne omejitve, ki jih moramo upoštevati v več funkcionalnostih ali celo skozi celoten razvoj aplikacije.

## 7. Prototipi vmesnikov

**TO-DO**

- Navesti je potrebno: zaslonske maske, sistemske vmesnike in vmesnike do naprav, vključno z referencami do primerov uporabe.

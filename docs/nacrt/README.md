# Načrt sistema

|                             |                                                                                  |
| :-------------------------- | :------------------------------------------------------------------------------- |
| **Naziv projekta**          | Pasjehodec                                                                       |
| **Člani projektne skupine** | Matjaž Bizjak, Primož Gabrovec, Aljaž Grdadolnik, Jakob Marušič, Mitja Vendramin |
| **Kraj in datum**           | Ljubljana, 1. april 2021                                                         |

> V tem dokumentu uporabljeni izrazi, ki se nanašajo na osebe in so zapisani v moški slovnični obliki, so uporabljeni kot nevtralni za ženski in moški spol.

## Povzetek

**TO-DO**

- Povzetek je, kot že vemo, celoten dokument, strnjen v največ 150 besed.

## 1. Načrt arhitekture

**TO-DO**

- Za prikaz uporabite enostavne prikaze, kot so blokovni ali paketni diagrami. Uporabite arhitekturne vzorce.

## 2. Načrt strukture

### 2.1 Razredni diagram

> V nadaljevanju predstavljamo dva globalna razredna diagrama, ki se delita na **razredni diagram zaledne aplikacije** in **razredni diagram čelne aplikacije**. Razredna diagrama sta ločena zaradi preglednosti, komunikacija med njima pa poteka prek _boundary_ razredov, ki so paroma enaki na obeh razrednih diagramih (npr. _boundary_ razred z imenom _UserApi_ na čelnem delu aplikacije predstavlja komunikacijsko točko z _boundary_ razredom _UserApi_ na zalednem delu, pri čemer sta si oba razreda _UserApi_ identična v imenu razerda in podpisu metod).

> Ravno tako ne definiramo _get_ in _set_ metod za _private_ polja razredov. Na razrednem diagramu tudi ne definiramo metod za _CRUD operacije_ nad entiteto ali skupino entitet. Vse metode, ki izvajajo takšne operacije znotraj celotne aplikacije sledijo naslednjemu konceptu:
> `<ime-operacije><ime-entitete>(<entiteta ali entiteta-id>, [...dodatni parametri])`
>
> - Pri čemer ima parameter `ime-operacije` eno izmed naslednjih vrednosti: `create`, `read`, `update`, `delete` ali `save` (save predstavlja skupek operacij create in update, pri čemer se slednja izvede v kolikor entiteta z enakim primarni identifikatorjem že obstaja)
> - Parameter `ime-entitete` je identifikator entitetnega razreda
> - Parameter `entiteta` (ali `entiteta-id`, ki predstavlja primarni identifikator entitete) predsatvlja entiteto nad katero se izvaja dana operacija. V kolikor ni podan se operacija izvede nad vsemi objekti tipa entiteta.
> - `dodatni-parametri` so neobvezen del CRUD operacije, v kolikor so definirani, so dodatno opisani ob definiciji.
>
> * Primer: metoda `createUser(User user)` kreira novo entiteto s parametri user tipa User, metoda `deleteUser(User user)` izbriše entiteto enako podani entiteti user tipa User.\*

#### Razredni diagram zalednega dela aplikacije

![](../img/3LP_razredniDiagram_backend.png)

#### Razredni diagram čelnega dela aplikacije

**TO-DO**

Zankrat upoštevaj, da so kontrolerji na frontendu enaki kot na backeendu. Boundary razredi za zaslonske maske pa se itak deifnira znotraj PU-

### 2.2 Opis razredov

V nadaljevanju opisujemo podrobneje opisujemo vse razrede problemske domene. Pri opisih podajamo naslednje tipe razreda:

- _entitetni tip_ je razred, ki predsatvlja smiselno celoto za hrambo dela podatkov in je neodvisen od okolja. Skupaj s primarnim identifikatorjem razreda predsatvlja osnovo za izgradnjo podatkovnega modela. Če ni drugače navedeno, entitetni razredi nimajo nesamoumevnih metod.

> Pri opisu atributov so izpuščeni atributi razreda, ki so samoumevni iz razrednega diagrama in niso bistvenega pomena za razumevanje oz. ne potrebujejo dodatne razlage.
> *Primer: iz razrednega diagrama je razvidno, da ima vsak objekt tipa User seznam objektov tipa Service, ki mu pripadajo. Vendar je ta asociacija samoumevna in ne potrebuje dodatnega pojasnila zato je pri opisu atributov izpuščena.*

#### **User**

Razred _User_ je entitetni razred, ki predstavlja registriranega uporabnika sistema. Z vsakega registriranega uporabnika obstaja natanko en objekt tega tipa.

#### Atributi

| Ime atributa | Tip atributa | Pomen atributa                                                              | Zaloga vrednosti |
| ------------ | ------------ | --------------------------------------------------------------------------- | ---------------- |
| id           | int          | Primarni identifikator razreda                                              |                  |
| name         | string       | ime uporabnika                                                              |                  |
| surname      | string       | priimek uporabnika                                                          |                  |
| email        | string       | epoštni naslov registriranega uporabnika (unikaten glede na tip uporabnika) |                  |
|username|string|uporabniško ime uporabnika, unikatno glede na tip uporabnika||
|password|string|kodirana vrednost uporabniškega gesla za dostop||
|usertype|string|tip uporabnika|IZVAJALEC_STORITVE, LASTNIK_PSA, MODERATOR, ADMINISTRATOR|

#### **Message**

Razred _Message_ je entitetni razred, ki predstavlja eno sporočilo v medsebojni komunikaciji med dvema uporabnikoma.

#### Atributi

| Ime atributa | Tip atributa | Pomen atributa | Zaloga vrednosti |
| ------------ | ------------ | -------------- | ---------------- |
| id | int | unikaten primarni identifikator objekta | |
| text | string | vsebina sporočila | |
| created | DateTime | čas kreiranja objekta | |
| sender | User | pošilljatelj sporočila | |
| recipient | User | prejemnik sporočila, pri čemer velja `this.sender !== this.recipient`| |

#### **Service**

Razred *Service* je entitetni razred, ki predstavlja eno objavljeno storitev v sistemu. Vsaka storitev pripada natanko enemu objektu tipa *User*.

#### Atributi

| Ime atributa | Tip atributa | Pomen atributa | Zaloga vrednosti |
| ------------ | ------------ | -------------- | ---------------- |
| id | int | unikaten primarni identifikator objekta | |
| name | string | opsino ime storitve | |
| description | string | daljši opis storitve | |
| restrictions | string | seznam omejitev pri izvedbi storitve | |
| dateFrom | DateTime | začetek ponujanja storitve | |
| dateTo | DateTime | konec ponujanja storitve | `dateFrom < dateTo` |

#### **Dogo**

Razred *Dogo* je entitetni razred, ki predstavlja enega psa vnešenega v sistema. Vsak pes pripada natanko enemu objektu tipa *User* (lastniku).

#### Atributi

| Ime atributa | Tip atributa | Pomen atributa | Zaloga vrednosti |
| ------------ | ------------ | -------------- | ---------------- |
| id | int | unikaten primarni identifikator objekta | |
| name | string | opisno ime psa ||
| breed | string | pasma psa ||
| breedId| string | id pasme, kot je definiran v zunanjem sistemu DogAPI ||

#### **ServiceDiary**

Razred *ServiceDiary* je entitetni razred, ki predstavlja eno opravljeno storitev tipa Service za en objekt tipa *Dogo*. V osnovi predstavlja mnogo-mnogo povezavo med objektoma tipa *Dogo* in *Service* z dodatnimi atributi o statusu, oceni in lokaciji.

#### Atributi

| Ime atributa | Tip atributa | Pomen atributa | Zaloga vrednosti |
| ------------ | ------------ | -------------- | ---------------- |
| id | int | unikaten primarni identifikator objekta | |
| assess | int | ocena opravljene storitve| `0 <= assess =< 5` |
| status| string | status storitve | ORDERED, CURRENT, FINNISHED, PAYED, CANCELLED |

#### **Location**

Razred *Location* je entitetni razred, ki predstavlja geografsko koordinato. Glede na dodatne asociativne povezave lahko predsatvlja lokacijo, kjer se določena storitev izvaja ali trenutno lokacijo psa med izvajanjem storitve.

#### Atributi

| Ime atributa | Tip atributa | Pomen atributa | Zaloga vrednosti |
| ------------ | ------------ | -------------- | ---------------- |
| id | int | unikaten primarni identifikator objekta | |
| date | DateTime | čas kreacije | |
| geoLat | double | Latituda lokacije | |
| geoLon | double | Longituda lokacije ||
| service | Service | storitev kateri pripada lokacija ||
| serviceDiary | ServiceDiary | izvedba storitve kateri pripada lokacija ||

Objekt tipa *Location* pripada bodisi objektu tipa *Service* bodisi objektu tipa *ServiceDiary*, torej je en izmed teh dveh atributov vedno nedefiniran (˙null`).

#### **PaymentType**

Razred *PaymentType* je entitetni razred, ki predstavlja plačilno sredstvo in je vedno vezan na natanko en razred tipa *User*.

#### Atributi

| Ime atributa | Tip atributa | Pomen atributa | Zaloga vrednosti |
| ------------ | ------------ | -------------- | ---------------- |
| id | int | unikaten primarni identifikator objekta | |
| cardNumber | string | številka plačilne kartice | niz števk 0-9 |
| cvv | string | varnostna koda plačilne kartice | trimestni niz števk 0-9 |
| expirationDate | Date | datum veljavnosti plačilne kartice | |
| default | boolean | Če je vrednost `true` gre za privzeto plačilno sredstvo na katero se privzeto prenašajo plačilne transakcije. ||

#### **Transaction**

Razred *Transaction* je entitetni razred, ki predstavlja plačilno transakcijo izvedeno med dvema objektoma tipa *PaymantType* in je vezan na en objekt tipa *ServiceDiary* (za izvedeno storitev).

#### Atributi

| Ime atributa | Tip atributa | Pomen atributa | Zaloga vrednosti |
| ------------ | ------------ | -------------- | ---------------- |
| id | int | unikaten primarni identifikator objekta | |
| date | DateTime | čas opravljene transakcije | |
| value | double | vrednost transkacije | |
| status | string | status transakcije | PENDING, COMPLETED |
| sender | PaymentType | plačilno sredstvo kateremu gre transakcija v breme ||
| recipient | PaymentType | plačilno sredstvo kateremu gre transakcija v dobro||
| service | ServiceDiary | storitev za katero se transkcija izvede||







#### Ime razreda **TO-DO**

- Koncept iz problemske domene, ki ga razred predstavlja.

#### Atributi

**TO-DO**

- Za vsak atribut navedite:
  - ime atributa,
  - podatkovni tip, če ta ni očiten,
  - pomen, če ta ni samoumeven,
  - zalogo vrednosti, če ta ni neomejena ali očitna.

#### Nesamoumevne metode

**TO-DO**

- Za vsako metodo navedite:
  - ime metode,
  - imena in tipe parametrov,
  - tip rezultata,
  - pomen (če ta ni dovolj očiten iz naziva metode in njenih parametrov).

## 3. Načrt obnašanja

**TO-DO**



- Za izdelavo načrta obnašanja lahko uporabite:
  - diagrame zaporedja,
  - končne avtomate,
  - diagrame aktivnosti,
  - diagrame stanj in
  - psevdokodo.
### Dodaj storitev
#### Osnovni tok
Storitev dodamo lahko samo kot uporabnik tipa "Izvajalec". Storitev dodamo tako, da na zaslonski maski "Pregled storitev" izberemo možnost "Dodaj novo storitev". Na novo odprti vlogi izpolnimo podatke in pritisnemo na gumb "Oddaj ponudbo". Podatki se zatem posredujejo kontrolerju, ki jih preko API klica posreduje strežniku. Kontroler na strani strežnika podatke vpiše v bazo, uporabniku pa se prikaže obvestilo o uspešnosti dodajanja storitve.

![](../img/dodaj_storitev_diagram_osnovni.png)

#### Alternativni tok
Storitev lahko dodamo prav tako iz zaslonske maske "Pregled preteklih storitev", kjer izberemo možnost "Dodaj novo storitev". Na vlogi izpolnimo podatke in pritisnemo gumb "Oddaj ponudbo". Po oddaji se podatki posredujejo strežniku, kjer se shranijo v bazo.Uporabniku se prikaže obvestilo o statusu oddaje.

![](../img/dodaj_storitev_diagram_alternativni.png)

### Dodaj psa
#### Osnovni tok

Psa lahko dodamo kot uporabnik tipa "Lastnik". Na zaslonski maski izberemo možnost "Dodaj novega psa". Na odprti vlogi izolnimo zahtevane podatke in kliknemo na gumb "Dodaj štirinožca". Podatki se preko kontrolerja posredujejo z API klicem na strežnik, kjer se preko kontrolerja zapišejo v bazo. Uporabniko se posreduje sporočilo o uspešnosti shranjevanja.

![](../img/dodaj_psa_diagram_osnovni.png)


#### Alternativni tok

Psa lahko dodamo tudi iz zavihka "Moji štirinožni prijatelji" na profilu uporabnika. Izberemo možnost "Dodaj novega štirinožca" in po izpolnitvi vloge pritisnemo na gumb "Dodaj štirinožca". Po oddaji se podatki posredujejo strežniku, ki zapiše podatke v bazo. Uporabniku se vrne status izvedene operacije.

![](../img/dodaj_psa_diagram_alternativni.png)

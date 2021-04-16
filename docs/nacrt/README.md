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

**TO-DO**

- Izdelajte razredni diagram.

### 2.2 Opis razredov

**TO-DO**

- Vsak razred podrobno opišite. Opis posameznega razreda naj ima sledečo strukturo:

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

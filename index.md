# NI-ADP 2021/22: MVC Game

## Implementované návrhové a architektonické vzory

* MVC
* Observer
* Abstract Factory
* Visitor
* Strategy
* State
* Memento
* Proxy
* Command
* Bridge
* Singleton
    * `CareTaker.java`
    * původní care-taker pro mementa modelu
    * nyní slouží jako care-taker Command
* **Builder**
    * složka `builder/`
    * konfigurovatelná alternativa k Factory pro GameInfo obou rodin
* **Template method**
    * rozdělení shoot na konfigurovatelné kroky v rámci `AbsCannon.java` a konkrétních implementací `CannonA.java` a `CannonB.java`
    * využito pro spuštění zvuku pro `CannonB.java`

## Herní a technické features navíc

* Zvuk při výstřelu pomocí CannonB
* Generický command přes reflexe
* Lepší řízení přepínání ShootingMode
    * metoda `nextState()`

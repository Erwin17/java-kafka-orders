# java-kafka-orders

## API Sicnrona basada en eventos

Se proporciona dos componente **[conssumer]**, **[producer]** como  ejemplo de un flujo basado en evento con **Apache Kafka***.

* **Consumer:** proporciona un EndPoinrt para enviar una order, este la toma y la enviar a un topics creado en **Apache Kafka**.

* **Producer:** Este componente se subcribe a un topics para poder consumer las ordenes enviadas por el productos. Posterior a eso la alamcena en una base de datos.

El ejemplo proporcionado esta basado en un API sicnrona, puede consultar el codigo fuente para mas detalles.


## API asyncrona sin bloquedo basada en evento
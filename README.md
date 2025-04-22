# java-kafka-products

## API Sicnrona basada en eventos

Se proporciona dos componentes **[conssumer]**, **[producer]** como  ejemplo de un flujo basado en evento con **Apache Kafka***.

* **Consumer:** proporciona un EndPoinrt para enviar un producto para su creacion y lo enviar a un topics creado en **Apache Kafka**.

* **Producer:** Este componente se subcribe a un topics para poder consumir las ordenes enviadas por el productor y lo imprime por consila.

El ejemplo proporcionado esta basado en un API sicnrona, puede consultar el codigo fuente para mas detalles.

NOTA:

Se proporciona un archivo **docker-compose.yml** para la creacion de un cluster de Kafka junto a un archivo **command.txt** para ejecutar la creacion del topics para el servios de ejemplo.

## API asyncrona sin bloquedo basada en evento


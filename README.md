# Description

## Vending machines system application:

Exist several vending machines. Every defined period of time each machine sends it's state, which contains information about products and money load and tech state of the machine. In the case of malfunction, lack of products or short change and in the case of full money box, system creates event of maintenance or repair. Every event assignes to one worker user. After successful maintanance or repair, event closes by worker. Worker saves all of the costs and stats of the work provided. Every day system saves average statistics by all of the machines, including count of sold products, malfunctions and average machines state. Manager is able to see current state of each machine in real time, search machines which require maintanance, observe statistics of total and average income, costs, find profitable, lossy, most and less popular machines and products. 

| №    | rout                                                         | method | description                     | input      | output              |
| ---- | ------------------------------------------------------------ | ------ | ------------------------------- | ---------- | ------------------- |
| 1    | api/user                                                     | POST   | addUse                          | userDto    | OperationStatusEnum |
| 2    | api/user/{userId:int}                                        | GET    | getUser                         | null       | userDto             |
| 3    | api/user/update/{userId:int}                                 | POST   | updateUser                      | userDto    | OperationStatusEnum |
| 4    | api/user/remove/{userId:int}                                 | DELETE | removeUser                      | null       | OperationStatusEnum |
| 5    | api/record/{recordId:int}                                    | GET    | getRecord                       | null       | RecordDto           |
| 6    | api/record/by_machine/{machineId:int}                        | GET    | getRecordsByMachine             | null       | RecordDto[]         |
| 7    | api/record/complite                                          | POST   | completeRecord                  | workDto    | OperationStatusEnum |
| 8    | api/record/by_period?sinse={dateFrom}&until={dateTo}         | GET    | getRecordsByPeriod              | null       | RecordDto[]         |
| 9    | api/machine                                                  | POST   | addMachine                      | MachineDto | OperationStatusEnum |
| 10   | api/machine/update                                           | POST   | updateMachine                   | MachineDto | OperationStatusEnum |
| 11   | api/machine/{machineId:int}                                  | GET    | getMachine                      | null       | MachineDto          |
| 12   | api/machine/{machineId:int}                                  | DELETE | removeMachine                   | null       | OperationStatusEnum |
| 13   | api/machine/state/{machineId:int}                            | GET    | getMachineState                 | null       | MachineStateDTO     |
| 14   | api/product                                                  | POST   | addProduct                      | ProductDto | OperationStatusEnum |
| 15   | api/product/{productId:int}                                  | GET    | getProduct                      | null       | ProductDto          |
| 16   | api/product/{productId:int}                                  | DELETE | removeProduct                   | null       | OperationStatusEnum |
| 17   | api/product/update                                           | POST   | updateProduct                   | ProductDto | OperationStatusEnum |
| 18   | api/product/fl_remove/{productId:int}                        | GET    | flRemove                        | null       | OperationStatusEnum |
| 19   | api/product/all                                              | GET    | getAllProduct                   | null       | ProductDto[]        |
| 20   | api/stat/income/by_period?sinse={dateFrom}&until={dateTo}    | GET    | getIncomeByPeriod               | null       | Map<LocalDate,int>  |
| 21   | api/stat/profit/avg/by_period?sinse={dateFrom}&until={dateTo} | GET    | getPeriodAvgProfit              | null       | float               |
| 22   | api/stat/profit/avg/{machineId:int}/by_period?sinse={dateFrom}&until={dateTo} | GET    | getMachineAvgProfit             | null       | float               |
| 23   | api/stat/profit/monthly/{machineId:int}/by_period?sinse={dateFrom}&until={dateTo} | GET    | getMonthlyMachineProfitByPeriod | null       | Map<String, int>    |
| 24   | api/stat/product/income/{productId:int}/by_period?sinse={dateFrom}&until={dateTo} | GET    | getProductIncome                | null       | int                 |
| 25   | api/stat/product/sell/{productId:int}/by_period?sinse={dateFrom}&until={dateTo} | GET    | getProductSellCount             | null       | int                 |
| 26   | api/stat/product/sell/by_period?sinse={dateFrom}&until={dateTo} | GET    | getListSoldProductsByPeriod     | null       | Map<Strin, int>     |
| 27   | api/stat/product/profit_most/by_period?sinse={dateFrom}&until={dateTo} | GET    | getMostProfitProductsByPeriod   | null       | ProductDto[]        |
| 28   | api/stat/product/profit_less/by_period?sinse={dateFrom}&until={dateTo} | GET    | getLessProfitProductsByPeriod   | null       | ProductDto[]        |
| 29   | api/stat/product/count_most/by_period?sinse={dateFrom}&until={dateTo} | GET    | getProfitMostSellCountProducts  | null       | ProductDto[]        |
| 30   | api/stat/product/count_less/by_period?sinse={dateFrom}&until={dateTo} | GET    | getProfitLessSellCountProducts  | null       | ProductDto[]        |
| 31   | api/stat/machine/friquency/{machineId:int}/by_period?sinse={dateFrom}&until={dateTo} | GET    | getServiceFriquency             | null       | int                 |
| 32   | api/stat/machine/broke_time/{machineId:int}&{year:int}       | GET    | getMachineBrokeTimeInYear       | null       | int                 |
| 33   | api/stat/product/current                                     | GET    | getCurrentProuctsCount          | null       | Map<String, int>    |

# kafka topics

1. SENSOR_COMMON
2. SENSOR_MALFUNCTION
3. SENSOR_MAINTANANCE
4. SENSOR_AVERAGE

| Sensor_id   | name                |
| ----------- | ------------------- |
| C-{number}  | Crash sensor        |
| MR-{number} | Money rest sensor   |
| MI-{number} | Money income sensor |
| P-{number}  | Product sensor      |
|             |                     |

Crash : [0-99]

P: [100-499]

MR: [500-699];

MI: [700-999]


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
| 21   | api/stat/profit/avg/by_period?sinse={dateFrom}&until={dateTo} | GET    | getPeriodAvgProfit              | null       | Map<int, int>       |
| 22   | api/stat/profit/avg/{machineId:int}/by_period?sinse={dateFrom}&until={dateTo} | GET    | getMachineAvgProfit             | null       | int                 |
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
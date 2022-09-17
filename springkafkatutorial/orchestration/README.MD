run(Shop).whenSuccess().run(PaymentService).whenSuccess().run(WarehouseService).whenSuccess().run()(ConsignmentService)
.whenSuccess().run(AnalysisService).whenSuccess(); when(Shop).hasUserRegistration().trigger(AnalysisService)
when(Shop).hasOrderGenerated().map(event -> AnalysisService.handleOrder()). when(Shop).has



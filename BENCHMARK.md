# VBD-spring-boot-payment-microservices: synthetic vulnerability benchmark

This fork is a **synthetic, openly labelled benchmark**. It is not the upstream project
and must not be used as one. Each sample is an isolated pair of branches off `baseline`:

- `baseline`: the pinned upstream commit plus any hardening; the common ancestor.
- `smpl/<NNN>/safe`: the genuine negative (validated control) of sample `NNN`.
- `smpl/<NNN>/vuln`: `safe` plus exactly one commit that weakens the control.

The class and the coordinates of every sample live only in `GROUND_TRUTH.csv` on this
orphan branch, never in the analysed branches.

| sample | file | class |
|---|---|---|
| 001 | `payment-validation-service/src/main/java/com/elos/payments/payment_validation_service/filter/HmacFilter.java` | F115 Security controls bypass or absence |
| 002 | `payment-processing-service/src/main/java/com/elos/payments/payment_processing_service/controller/ProcessingController.java` | F305 Security controls bypass or absence - Data creation |
| 003 | `payment-validation-service/src/main/java/com/elos/payments/payment_validation_service/controller/PaymentValidationController.java` | F115 Security controls bypass or absence |

//package com.common.rain.handler;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//
//
//import org.apache.rocketmq.shaded.com.google.protobuf.ServiceException;
//import org.slf4j.MDC;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.dao.DataAccessException;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.util.CollectionUtils;
//import org.springframework.validation.BindException;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.multipart.MaxUploadSizeExceededException;
//
//
///**
// * 异常统一处理
// *
// * @author lanyang
// **/
//
//@RestControllerAdvice
////@Slf4j
//public class GlobalExceptionHandler {
//
//    public static final String BUSINESS_ID_KEY = "businessID";
//
//
//    @Value("${spring.servlet.multipart.max-file-size}")
//    private String maxFileSize;
//
//    /**
//     * 数据验证异常
//     */
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public JsonResult<Object> handle(MethodArgumentNotValidException e) {
//        BindingResult bindingResult = e.getBindingResult();
//        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
//        if (!CollectionUtils.isEmpty(fieldErrorList)) {
//            Optional<FieldError> optional = fieldErrorList.stream().findFirst();
//            if (optional.isPresent()) {
//                return JsonResult.error(optional.get().getDefaultMessage());
//            }
//        }
//        return JsonResult.error(e.getMessage());
//    }
//
//    /**
//     * 处理数据持久化层异常
//     */
//    @ExceptionHandler(value = DataAccessException.class)
//    public JsonResult<Object> handle(DataAccessException e) {
//        e.printStackTrace();
//        log.warn("全局异常统一处理DataAccessException:" + e.getMessage());
//        return JsonResult.error("数据处理错误");
//    }
//
//    /**
//     * 无访问权限
//     */
//    @ExceptionHandler(value = DataAuthorityException.class)
//    public JsonResult<Object> purchaseDataAuthorityException(DataAuthorityException e) {
//        String uuid = StrUtil.format("{}-{}", TokenUtil.getUserId(), LocalDateTime.now());
//        MDC.put(BUSINESS_ID_KEY, uuid);
//        log.warn("全局异常统一处理PurchaseException", e);
//        MDC.remove(BUSINESS_ID_KEY);
//        return JsonResult.error(506, "当前车辆无访问权限");
//    }
//
//    /**
//     * 处理数据持久化层异常
//     */
//    @ExceptionHandler(value = DuplicateKeyException.class)
//    public JsonResult<Object> handle(DuplicateKeyException e) {
//        e.printStackTrace();
//        log.warn("全局异常统一处理DuplicateKeyException:" + e.getMessage());
//        return JsonResult.error("数据处理错误");
//    }
//
//    /**
//     * 处理数据持久化层异常
//     */
//    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
//    public JsonResult<Object> handle(MaxUploadSizeExceededException e) {
//        log.warn("上传文件的异常:" + e.getMessage());
//        return JsonResult.error("上传文件不能超过" + maxFileSize);
//    }
//
//    @ExceptionHandler(BindException.class)
//    public JsonResult<?> bindExceptionHandler(BindException ex) {
//        log.warn("[handleBindException]", ex);
//        FieldError fieldError = ex.getFieldError();
//        assert fieldError != null; // 断言，避免告警
//        return JsonResult.error(500, String.format("请求参数不正确:%s", fieldError.getDefaultMessage()));
//    }
//
//    /**
//     * 处理 Validator 校验不通过产生的异常
//     */
//    @ExceptionHandler(value = ConstraintViolationException.class)
//    public JsonResult<?> constraintViolationExceptionHandler(ConstraintViolationException ex) {
//        log.warn("[constraintViolationExceptionHandler]", ex);
//        ConstraintViolation<?> constraintViolation = ex.getConstraintViolations().iterator().next();
//        return JsonResult.error(500, String.format("请求参数不正确:%s", constraintViolation.getMessage()));
//    }
//
//
//    @ExceptionHandler(value = ServiceException.class)
//    public JsonResultExt<?> serviceExceptionHandler(ServiceException ex) {
//        log.info("[serviceExceptionHandler] traceId {}", MDC.get(CommonConst.TRACE_ID), ex);
//        return JsonResultExt.error(ex.getCode(), ex.getMessage(), MDC.get(CommonConst.TRACE_ID));
//    }
//
//
//    @ExceptionHandler(value = Exception.class)
//    public JsonResult<Object> handle(Exception e) {
//        log.warn("全局异常统一处理:" + e.getMessage());
//        e.printStackTrace();
//        return JsonResult.error(e.getMessage());
//    }
//}

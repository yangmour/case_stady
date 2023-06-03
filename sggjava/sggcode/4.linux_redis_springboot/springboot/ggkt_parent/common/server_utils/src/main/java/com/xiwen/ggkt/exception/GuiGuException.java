package com.xiwen.ggkt.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/03 -09:26
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuiGuException extends RuntimeException {
    private Integer code;
    private String msg;
}

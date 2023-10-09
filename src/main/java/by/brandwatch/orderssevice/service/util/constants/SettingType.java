package by.brandwatch.orderssevice.service.util.constants;

import lombok.Getter;

@Getter
public enum SettingType {

    BODY_TYPE("Тип корпуса"),
    BRAND("Бренд"),
    CATEGORY("Категория"),
    COLOR("Цвет"),
    MECHANISM("Механизм");

    private final String stringValue;

    SettingType(String stringValue) {
        this.stringValue = stringValue;
    }

}

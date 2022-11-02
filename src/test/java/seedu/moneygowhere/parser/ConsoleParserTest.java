package seedu.moneygowhere.parser;

import org.junit.jupiter.api.Test;
import seedu.moneygowhere.commands.ConsoleCommandAddExpense;
import seedu.moneygowhere.commands.ConsoleCommandAddRecurringPayment;
import seedu.moneygowhere.commands.ConsoleCommandDeleteExpense;
import seedu.moneygowhere.commands.ConsoleCommandEditExpense;
import seedu.moneygowhere.commands.ConsoleCommandViewExpense;
import seedu.moneygowhere.commands.ConsoleCommandViewRecurringPayment;
import seedu.moneygowhere.commands.ConsoleCommandMergeExternalFile;
import seedu.moneygowhere.common.Configurations;
import seedu.moneygowhere.exceptions.MoneyGoWhereException;
import seedu.moneygowhere.exceptions.parser.ConsoleParserCommandAddExpenseInvalidException;
import seedu.moneygowhere.exceptions.parser.ConsoleParserCommandAddRecurringPaymentInvalidException;
import seedu.moneygowhere.exceptions.parser.ConsoleParserCommandDeleteExpenseInvalidException;
import seedu.moneygowhere.exceptions.parser.ConsoleParserCommandEditExpenseInvalidException;
import seedu.moneygowhere.exceptions.parser.ConsoleParserCommandViewExpenseInvalidException;
import seedu.moneygowhere.exceptions.parser.ConsoleParserCommandViewRecurringPaymentInvalidException;
import seedu.moneygowhere.exceptions.parser.ConsoleParserCommandMergeExternalFileInvalidException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConsoleParserTest {
    //@@author xzynos
    @SuppressWarnings("ConstantConditions")
    @Test
    void parseCommand_aeNameAmount_ccaeNameAmountDateTime() throws
            MoneyGoWhereException {
        String name = "Exp";
        BigDecimal amount = new BigDecimal("7.80");

        String input = ""
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_NAME
                + " "
                + name
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_AMOUNT
                + " "
                + amount;

        ConsoleCommandAddExpense consoleCommandAddExpense = (ConsoleCommandAddExpense) ConsoleParser.parse(input);

        boolean isNameEqual = consoleCommandAddExpense
                .getName()
                .equals(name);
        boolean isDateTimeEqual = true;
        boolean isDescriptionEqual = consoleCommandAddExpense
                .getDescription()
                == null;
        boolean isAmountEqual = consoleCommandAddExpense
                .getAmount()
                .equals(amount.stripTrailingZeros());
        boolean isCategoryEqual = consoleCommandAddExpense
                .getCategory()
                == null;

        assertTrue(
                isNameEqual
                        && isDateTimeEqual
                        && isDescriptionEqual
                        && isAmountEqual
                        && isCategoryEqual);
    }

    //@@author xzynos
    @Test
    void parseCommand_aeNameAmountDateTime_ccaeNameAmountDateTime() throws
            MoneyGoWhereException {
        String name = "Exp";
        BigDecimal amount = new BigDecimal("7.80");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(
                Configurations.CONSOLE_INTERFACE_DATE_TIME_INPUT_FORMAT
        );
        LocalDateTime dateTime = LocalDateTime.parse("01/01/2022 2359", dateTimeFormatter);

        String input = ""
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_NAME
                + " "
                + name
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_AMOUNT
                + " "
                + amount
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_DATE_TIME
                + " \""
                + dateTime.format(dateTimeFormatter)
                + "\"";

        ConsoleCommandAddExpense consoleCommandAddExpense = (ConsoleCommandAddExpense) ConsoleParser.parse(input);

        boolean isNameEqual = consoleCommandAddExpense
                .getName()
                .equals(name);
        boolean isDateTimeEqual = consoleCommandAddExpense
                .getDateTime()
                .equals(dateTime);
        boolean isDescriptionEqual = consoleCommandAddExpense
                .getDescription()
                == null;
        boolean isAmountEqual = consoleCommandAddExpense
                .getAmount()
                .equals(amount.stripTrailingZeros());
        boolean isCategoryEqual = consoleCommandAddExpense
                .getCategory()
                == null;
        boolean isModeOfPaymentEqual = consoleCommandAddExpense
                .getModeOfPayment()
                == null;

        assertTrue(
                isNameEqual
                        && isDateTimeEqual
                        && isDescriptionEqual
                        && isAmountEqual
                        && isCategoryEqual
                        && isModeOfPaymentEqual);
    }

    //@@author xzynos
    @Test
    void parseCommand_aeNameAmountDateTimeDescription_ccaeNameAmountDateTimeDescription() throws
            MoneyGoWhereException {
        String name = "Exp";
        BigDecimal amount = new BigDecimal("7.80");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(
                Configurations.CONSOLE_INTERFACE_DATE_TIME_INPUT_FORMAT
        );
        LocalDateTime dateTime = LocalDateTime.parse("01/01/2022 2359", dateTimeFormatter);
        String description = "Test Desc";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_NAME
                + " "
                + name
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_AMOUNT
                + " "
                + amount
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_DATE_TIME
                + " \""
                + dateTime.format(dateTimeFormatter)
                + "\" -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_DESCRIPTION
                + " \""
                + description
                + "\"";

        ConsoleCommandAddExpense consoleCommandAddExpense = (ConsoleCommandAddExpense) ConsoleParser.parse(input);

        boolean isNameEqual = consoleCommandAddExpense
                .getName()
                .equals(name);
        boolean isDateTimeEqual = consoleCommandAddExpense
                .getDateTime()
                .equals(dateTime);
        boolean isDescriptionEqual = consoleCommandAddExpense
                .getDescription()
                .equals(description);
        boolean isAmountEqual = consoleCommandAddExpense
                .getAmount()
                .equals(amount.stripTrailingZeros());
        boolean isCategoryEqual = consoleCommandAddExpense
                .getCategory()
                == null;

        assertTrue(
                isNameEqual
                        && isDateTimeEqual
                        && isDescriptionEqual
                        && isAmountEqual
                        && isCategoryEqual);
    }

    //@@author xzynos
    @Test
    void parseCommand_aeNameAmountDateTimeDescriptionCategory_ccaeNameAmountDateTimeDescriptionCategory() throws
            MoneyGoWhereException {
        String name = "Exp";
        BigDecimal amount = new BigDecimal("7.80");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(
                Configurations.CONSOLE_INTERFACE_DATE_TIME_INPUT_FORMAT
        );
        LocalDateTime dateTime = LocalDateTime.parse("01/01/2022 2359", dateTimeFormatter);
        String description = "Test Desc";
        String category = "Test Cat";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_NAME
                + " "
                + name
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_AMOUNT
                + " "
                + amount
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_DATE_TIME
                + " \""
                + dateTime.format(dateTimeFormatter)
                + "\" -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_DESCRIPTION
                + " \""
                + description
                + "\" -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_CATEGORY_LONG
                + " \""
                + category
                + "\"";

        ConsoleCommandAddExpense consoleCommandAddExpense = (ConsoleCommandAddExpense) ConsoleParser.parse(input);

        boolean isNameEqual = consoleCommandAddExpense
                .getName()
                .equals(name);
        boolean isDateTimeEqual = consoleCommandAddExpense
                .getDateTime()
                .equals(dateTime);
        boolean isDescriptionEqual = consoleCommandAddExpense
                .getDescription()
                .equals(description);
        boolean isAmountEqual = consoleCommandAddExpense
                .getAmount()
                .equals(amount.stripTrailingZeros());
        boolean isCategoryEqual = consoleCommandAddExpense
                .getCategory()
                .equals(category);

        assertTrue(
                isNameEqual
                        && isDateTimeEqual
                        && isDescriptionEqual
                        && isAmountEqual
                        && isCategoryEqual);
    }

    //@@author xzynos
    @Test
    void parseCommand_aeName_ccaeInvalidException() {
        String name = "Exp";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_NAME
                + " "
                + name;

        assertThrows(ConsoleParserCommandAddExpenseInvalidException.class, () ->
                ConsoleParser.parse(input));
    }

    //@@author xzynos
    @Test
    void parseCommand_aeNameAmount_ccaeInvalidException() {
        String name = "Exp";
        String amount = "InvalidAmount";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_NAME
                + " "
                + name
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_AMOUNT
                + " \""
                + amount
                + "\"";

        assertThrows(ConsoleParserCommandAddExpenseInvalidException.class, () ->
                ConsoleParser.parse(input));
    }

    //@@author xzynos
    @Test
    void parseCommand_aeNameAmountDateTime_ccaeInvalidException() {
        String name = "Exp";
        String amount = "7.80";
        String dateTime = "InvalidDateTime";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_NAME
                + " "
                + name
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_AMOUNT
                + " "
                + amount
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_EXPENSE_ARG_DATE_TIME
                + " \""
                + dateTime
                + "\"";

        assertThrows(ConsoleParserCommandAddExpenseInvalidException.class, () ->
                ConsoleParser.parse(input));
    }

    //@@author xzynos
    @Test
    void parseCommand_ve_ccve() throws
            MoneyGoWhereException {
        String input = ""
                + ConsoleParserConfigurations.COMMAND_VIEW_EXPENSE;

        ConsoleCommandViewExpense consoleCommandViewExpense = (ConsoleCommandViewExpense) ConsoleParser.parse(input);

        boolean isExpenseIndexEqual = consoleCommandViewExpense
                .getExpenseIndex()
                == -1;

        assertTrue(isExpenseIndexEqual);
    }

    //@@author xzynos
    @Test
    void parseCommand_veIndex_ccveIndex() throws
            MoneyGoWhereException {
        int expenseIndex = 0;

        String input = ""
                + ConsoleParserConfigurations.COMMAND_VIEW_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_VIEW_EXPENSE_ARG_EXPENSE_INDEX
                + " "
                + expenseIndex;

        ConsoleCommandViewExpense consoleCommandViewExpense = (ConsoleCommandViewExpense) ConsoleParser.parse(input);

        boolean isExpenseIndexEqual = consoleCommandViewExpense
                .getExpenseIndex()
                == expenseIndex;

        assertTrue(isExpenseIndexEqual);
    }

    //@@author xzynos
    @Test
    void parseCommand_veIndex_ccveInvalidException() {
        String expenseIndex = "InvalidExpenseIndex";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_VIEW_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_VIEW_EXPENSE_ARG_EXPENSE_INDEX
                + " \""
                + expenseIndex
                + "\"";

        assertThrows(ConsoleParserCommandViewExpenseInvalidException.class, () ->
                ConsoleParser.parse(input));
    }

    //@@author xzynos
    @Test
    void parseCommand_deIndex_ccdeIndex() throws
            MoneyGoWhereException {
        int expenseIndex = 0;

        String input = ""
                + ConsoleParserConfigurations.COMMAND_DELETE_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_DELETE_EXPENSE_ARG_EXPENSE_INDEX
                + " "
                + expenseIndex;

        ConsoleCommandDeleteExpense consoleCommandDeleteExpense =
                (ConsoleCommandDeleteExpense) ConsoleParser.parse(input);

        boolean isExpenseIndexEqual = consoleCommandDeleteExpense
                .getExpenseIndex()
                == expenseIndex;

        assertTrue(isExpenseIndexEqual);
    }

    //@@author xzynos
    @Test
    void parseCommand_de_ccdeInvalidException() {
        String input = ""
                + ConsoleParserConfigurations.COMMAND_DELETE_EXPENSE;

        assertThrows(ConsoleParserCommandDeleteExpenseInvalidException.class, () ->
                ConsoleParser.parse(input));
    }

    //@@author xzynos
    @Test
    void parseCommand_deIndex_ccdeInvalidException() {
        String expenseIndex = "InvalidExpenseIndex";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_DELETE_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_DELETE_EXPENSE_ARG_EXPENSE_INDEX
                + " \""
                + expenseIndex
                + "\"";

        assertThrows(ConsoleParserCommandDeleteExpenseInvalidException.class, () ->
                ConsoleParser.parse(input));
    }

    //@@author xzynos
    @Test
    void parseCommand_eeIndexName_cceeIndexName() throws
            MoneyGoWhereException {
        int expenseIndex = 0;
        String name = "Exp";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_EXPENSE_INDEX
                + " "
                + expenseIndex
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_NAME
                + " "
                + name;

        ConsoleCommandEditExpense consoleCommandEditExpense = (ConsoleCommandEditExpense) ConsoleParser.parse(input);

        boolean isIndexEqual = consoleCommandEditExpense
                .getExpenseIndex()
                == 0;
        boolean isNameEqual = consoleCommandEditExpense
                .getName()
                .equals(name);
        boolean isDateTimeEqual = consoleCommandEditExpense
                .getDateTime()
                == null;
        boolean isDescriptionEqual = consoleCommandEditExpense
                .getDescription()
                == null;
        boolean isAmountEqual = consoleCommandEditExpense
                .getAmount()
                == null;
        boolean isCategoryEqual = consoleCommandEditExpense
                .getCategory()
                == null;

        assertTrue(
                isIndexEqual
                        && isNameEqual
                        && isDateTimeEqual
                        && isDescriptionEqual
                        && isAmountEqual
                        && isCategoryEqual);
    }

    //@@author xzynos
    @Test
    void parseCommand_eeIndexNameAmount_cceeIndexNameAmount() throws
            MoneyGoWhereException {
        int expenseIndex = 0;
        String name = "Exp";
        BigDecimal amount = new BigDecimal("7.80");

        String input = ""
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_EXPENSE_INDEX
                + " "
                + expenseIndex
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_NAME
                + " "
                + name
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_AMOUNT
                + " "
                + amount;

        ConsoleCommandEditExpense consoleCommandEditExpense = (ConsoleCommandEditExpense) ConsoleParser.parse(input);

        boolean isIndexEqual = consoleCommandEditExpense
                .getExpenseIndex()
                == expenseIndex;
        boolean isNameEqual = consoleCommandEditExpense
                .getName()
                .equals(name);
        boolean isDateTimeEqual = consoleCommandEditExpense
                .getDateTime()
                == null;
        boolean isDescriptionEqual = consoleCommandEditExpense
                .getDescription()
                == null;
        boolean isAmountEqual = consoleCommandEditExpense
                .getAmount()
                .equals(amount.stripTrailingZeros());
        boolean isCategoryEqual = consoleCommandEditExpense
                .getCategory()
                == null;

        assertTrue(
                isIndexEqual
                        && isNameEqual
                        && isDateTimeEqual
                        && isDescriptionEqual
                        && isAmountEqual
                        && isCategoryEqual);
    }

    //@@author xzynos
    @Test
    void parseCommand_eeIndexNameAmountDateTime_cceeIndexNameAmountDateTime() throws
            MoneyGoWhereException {
        int expenseIndex = 0;
        String name = "Exp";
        BigDecimal amount = new BigDecimal("7.80");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        LocalDateTime dateTime = LocalDateTime.parse("01/01/2022 2359", dateTimeFormatter);

        String input = ""
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_EXPENSE_INDEX
                + " "
                + expenseIndex
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_NAME
                + " "
                + name
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_AMOUNT
                + " "
                + amount
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_DATE_TIME
                + " \""
                + dateTime.format(dateTimeFormatter)
                + "\"";

        ConsoleCommandEditExpense consoleCommandEditExpense = (ConsoleCommandEditExpense) ConsoleParser.parse(input);

        boolean isIndexEqual = consoleCommandEditExpense
                .getExpenseIndex()
                == expenseIndex;
        boolean isNameEqual = consoleCommandEditExpense
                .getName()
                .equals(name);
        boolean isDateTimeEqual = consoleCommandEditExpense
                .getDateTime()
                .equals(dateTime);
        boolean isDescriptionEqual = consoleCommandEditExpense
                .getDescription()
                == null;
        boolean isAmountEqual = consoleCommandEditExpense
                .getAmount()
                .equals(amount.stripTrailingZeros());
        boolean isCategoryEqual = consoleCommandEditExpense
                .getCategory()
                == null;

        assertTrue(
                isIndexEqual
                        && isNameEqual
                        && isDateTimeEqual
                        && isDescriptionEqual
                        && isAmountEqual
                        && isCategoryEqual);
    }

    //@@author xzynos
    @Test
    void parseCommand_eeIndexNameAmountDateTimeDescription_cceeIndexNameAmountDateTimeDescription() throws
            MoneyGoWhereException {
        int expenseIndex = 0;
        String name = "Exp";
        BigDecimal amount = new BigDecimal("7.80");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        LocalDateTime dateTime = LocalDateTime.parse("01/01/2022 2359", dateTimeFormatter);
        String description = "Test Desc";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_EXPENSE_INDEX
                + " "
                + expenseIndex
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_NAME
                + " "
                + name
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_AMOUNT
                + " "
                + amount
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_DATE_TIME
                + " \""
                + dateTime.format(dateTimeFormatter)
                + "\" -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_DESCRIPTION
                + " \""
                + description
                + "\"";

        ConsoleCommandEditExpense consoleCommandEditExpense = (ConsoleCommandEditExpense) ConsoleParser.parse(input);

        boolean isIndexEqual = consoleCommandEditExpense
                .getExpenseIndex()
                == expenseIndex;
        boolean isNameEqual = consoleCommandEditExpense
                .getName()
                .equals(name);
        boolean isDateTimeEqual = consoleCommandEditExpense
                .getDateTime()
                .equals(dateTime);
        boolean isDescriptionEqual = consoleCommandEditExpense
                .getDescription()
                .equals(description);
        boolean isAmountEqual = consoleCommandEditExpense
                .getAmount()
                .equals(amount.stripTrailingZeros());
        boolean isCategoryEqual = consoleCommandEditExpense
                .getCategory()
                == null;

        assertTrue(
                isIndexEqual
                        && isNameEqual
                        && isDateTimeEqual
                        && isDescriptionEqual
                        && isAmountEqual
                        && isCategoryEqual);
    }

    //@@author xzynos
    @Test
    void parseCommand_eeIndexNameAmountDateTimeDescriptionCategory_cceeIndexNameAmountDateTimeDescriptionCategory()
            throws
            MoneyGoWhereException {
        int expenseIndex = 0;
        String name = "Exp";
        BigDecimal amount = new BigDecimal("7.80");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        LocalDateTime dateTime = LocalDateTime.parse("01/01/2022 2359", dateTimeFormatter);
        String description = "Test Desc";
        String category = "Test Cat";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_EXPENSE_INDEX
                + " "
                + expenseIndex
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_NAME
                + " "
                + name
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_AMOUNT
                + " "
                + amount
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_DATE_TIME
                + " \""
                + dateTime.format(dateTimeFormatter)
                + "\" -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_DESCRIPTION
                + " \""
                + description
                + "\" -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_CATEGORY
                + " \""
                + category
                + "\"";

        ConsoleCommandEditExpense consoleCommandEditExpense = (ConsoleCommandEditExpense) ConsoleParser.parse(input);

        boolean isIndexEqual = consoleCommandEditExpense
                .getExpenseIndex()
                == expenseIndex;
        boolean isNameEqual = consoleCommandEditExpense
                .getName()
                .equals(name);
        boolean isDateTimeEqual = consoleCommandEditExpense
                .getDateTime()
                .equals(dateTime);
        boolean isDescriptionEqual = consoleCommandEditExpense
                .getDescription()
                .equals(description);
        boolean isAmountEqual = consoleCommandEditExpense
                .getAmount()
                .equals(amount.stripTrailingZeros());
        boolean isCategoryEqual = consoleCommandEditExpense
                .getCategory()
                .equals(category);

        assertTrue(
                isIndexEqual
                        && isNameEqual
                        && isDateTimeEqual
                        && isDescriptionEqual
                        && isAmountEqual
                        && isCategoryEqual);
    }

    //@@author xzynos
    @Test
    void parseCommand_ee_cceeInvalidException() {
        String input = ""
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE;

        assertThrows(ConsoleParserCommandEditExpenseInvalidException.class, () ->
                ConsoleParser.parse(input));
    }

    //@@author xzynos
    @Test
    void parseCommand_eeIndex_cceeInvalidException() {
        String expenseIndex = "InvalidExpenseIndex";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_EXPENSE_INDEX
                + " \""
                + expenseIndex
                + "\"";

        assertThrows(ConsoleParserCommandEditExpenseInvalidException.class, () ->
                ConsoleParser.parse(input));
    }

    //@@author xzynos
    @Test
    void parseCommand_eeIndexAmount_cceeInvalidException() {
        String expenseIndex = "0";
        String amount = "InvalidAmount";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_EXPENSE_INDEX
                + " "
                + expenseIndex
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_AMOUNT
                + " \""
                + amount
                + "\"";

        assertThrows(ConsoleParserCommandEditExpenseInvalidException.class, () ->
                ConsoleParser.parse(input));
    }

    //@@author xzynos
    @Test
    void parseCommand_eeIndexAmountDateTime_cceeInvalidException() {
        String expenseIndex = "0";
        String amount = "7.80";
        String dateTime = "InvalidDateTime";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_EXPENSE_INDEX
                + " "
                + expenseIndex
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_AMOUNT
                + " "
                + amount
                + " -"
                + ConsoleParserConfigurations.COMMAND_EDIT_EXPENSE_ARG_DATE_TIME
                + " \""
                + dateTime
                + "\"";

        assertThrows(ConsoleParserCommandEditExpenseInvalidException.class, () ->
                ConsoleParser.parse(input));
    }

    //@@author xzynos
    @Test
    void parseCommand_arpNameIntervalAmount_ccarpNameIntervalAmount() throws
            MoneyGoWhereException {
        String name = "RecurPay1";
        int interval = 30;
        BigDecimal amount = new BigDecimal("7.80");

        String input = ""
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT_ARG_NAME
                + " "
                + name
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT_ARG_INTERVAL
                + " "
                + interval
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT_ARG_AMOUNT
                + " "
                + amount;

        ConsoleCommandAddRecurringPayment consoleCommandAddRecurringPayment =
                (ConsoleCommandAddRecurringPayment) ConsoleParser.parse(input);

        boolean isNameEqual = consoleCommandAddRecurringPayment
                .getName()
                .equals(name);
        boolean isIntervalEqual = consoleCommandAddRecurringPayment
                .getInterval()
                == interval;
        boolean isAmountEqual = consoleCommandAddRecurringPayment
                .getAmount()
                .equals(amount.stripTrailingZeros());

        assertTrue(
                isNameEqual
                        && isIntervalEqual
                        && isAmountEqual
        );
    }

    //@@author xzynos
    @Test
    void parseCommand_arpNameIntervalAmountDescription_ccarpNameIntervalAmountDescription() throws
            MoneyGoWhereException {
        String name = "RecurPay1";
        int interval = 30;
        BigDecimal amount = new BigDecimal("7.80");
        String description = "Test Desc";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT_ARG_NAME
                + " "
                + name
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT_ARG_INTERVAL
                + " "
                + interval
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT_ARG_AMOUNT
                + " "
                + amount
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT_ARG_DESCRIPTION
                + " "
                + "\"" + description + "\"";

        ConsoleCommandAddRecurringPayment consoleCommandAddRecurringPayment =
                (ConsoleCommandAddRecurringPayment) ConsoleParser.parse(input);

        boolean isNameEqual = consoleCommandAddRecurringPayment
                .getName()
                .equals(name);
        boolean isIntervalEqual = consoleCommandAddRecurringPayment
                .getInterval()
                == interval;
        boolean isAmountEqual = consoleCommandAddRecurringPayment
                .getAmount()
                .equals(amount.stripTrailingZeros());
        boolean isDescriptionEqual = consoleCommandAddRecurringPayment
                .getDescription()
                .equals(description);

        assertTrue(
                isNameEqual
                        && isIntervalEqual
                        && isAmountEqual
                        && isDescriptionEqual
        );
    }

    //@@author xzynos
    @Test
    void parseCommand_arp_ccarpInvalidException() {
        String input = ""
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT;

        assertThrows(
                ConsoleParserCommandAddRecurringPaymentInvalidException.class, () -> ConsoleParser.parse(input)
        );
    }

    //@@author xzynos
    @Test
    void parseCommand_arpName_ccarpInvalidException() {
        String name = "RecurPay1";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT_ARG_NAME
                + " "
                + name;

        assertThrows(
                ConsoleParserCommandAddRecurringPaymentInvalidException.class, () -> ConsoleParser.parse(input)
        );
    }

    //@@author xzynos
    @Test
    void parseCommand_arpNameInterval_ccarpInvalidException() {
        String name = "RecurPay1";
        int interval = 30;

        String input = ""
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT_ARG_NAME
                + " "
                + name
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT_ARG_INTERVAL
                + " "
                + interval;

        assertThrows(
                ConsoleParserCommandAddRecurringPaymentInvalidException.class, () -> ConsoleParser.parse(input)
        );
    }

    //@@author xzynos
    @Test
    void parseCommand_arpNameInvalidInterval_ccarpInvalidException() {
        String name = "RecurPay1";
        String interval = "InvalidInterval";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT_ARG_NAME
                + " "
                + name
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT_ARG_INTERVAL
                + " "
                + interval;

        assertThrows(
                ConsoleParserCommandAddRecurringPaymentInvalidException.class, () -> ConsoleParser.parse(input)
        );
    }

    //@@author xzynos
    @Test
    void parseCommand_arpNameIntervalInvalidAmount_ccarpInvalidException() {
        String name = "RecurPay1";
        int interval = 30;
        String amount = "InvalidAmount";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT_ARG_NAME
                + " "
                + name
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT_ARG_INTERVAL
                + " "
                + interval
                + " -"
                + ConsoleParserConfigurations.COMMAND_ADD_RECURRING_PAYMENT_ARG_AMOUNT
                + " "
                + amount;

        assertThrows(
                ConsoleParserCommandAddRecurringPaymentInvalidException.class, () -> ConsoleParser.parse(input)
        );
    }

    //@@author xzynos
    @Test
    void parseCommand_vrp_ccvrp() throws
            MoneyGoWhereException {
        String input = ""
                + ConsoleParserConfigurations.COMMAND_VIEW_RECURRING_PAYMENT;

        ConsoleCommandViewRecurringPayment consoleCommandViewRecurringPayment =
                (ConsoleCommandViewRecurringPayment) ConsoleParser.parse(input);

        boolean isRecurringPaymentIndexEqual = consoleCommandViewRecurringPayment
                .getRecurringPaymentIndex()
                == -1;

        assertTrue(isRecurringPaymentIndexEqual);
    }

    //@@author xzynos
    @Test
    void parseCommand_vrpIndex_ccvrpIndex() throws
            MoneyGoWhereException {
        int recurringPaymentIndex = 1337;

        String input = ""
                + ConsoleParserConfigurations.COMMAND_VIEW_RECURRING_PAYMENT
                + " -"
                + ConsoleParserConfigurations.COMMAND_VIEW_RECURRING_PAYMENT_ARG_RECURRING_PAYMENT_INDEX
                + " "
                + recurringPaymentIndex;

        ConsoleCommandViewRecurringPayment consoleCommandViewRecurringPayment =
                (ConsoleCommandViewRecurringPayment) ConsoleParser.parse(input);

        boolean isRecurringPaymentIndexEqual = consoleCommandViewRecurringPayment
                .getRecurringPaymentIndex()
                == recurringPaymentIndex;

        assertTrue(isRecurringPaymentIndexEqual);
    }

    //@@author xzynos
    @Test
    void parseCommand_vrpInvalidIndex_ccvrpInvalidException() {
        String recurringPaymentIndex = "InvalidIndex";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_VIEW_RECURRING_PAYMENT
                + " -"
                + ConsoleParserConfigurations.COMMAND_VIEW_RECURRING_PAYMENT_ARG_RECURRING_PAYMENT_INDEX
                + " "
                + recurringPaymentIndex;

        assertThrows(ConsoleParserCommandViewRecurringPaymentInvalidException.class, () ->
                ConsoleParser.parse(input)
        );
    }

    //@@author LokQiJun
    @Test
    void parseCommand_mefPath_ccmefPath() throws
            MoneyGoWhereException {
        String filePath = "C:/ValidPath/MoneyGoWhereData.xml";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_MERGE_FILE
                + " -"
                + ConsoleParserConfigurations.COMMAND_MERGE_FILE_ARG_MERGE_FILE_PATH
                + " "
                + filePath;
        System.out.print(input);
        ConsoleCommandMergeExternalFile consoleCommandMergeExternalFile =
                (ConsoleCommandMergeExternalFile) ConsoleParser.parse(input);

        boolean isFilePathEqual = consoleCommandMergeExternalFile.getFilePath().equals(filePath);

        assertTrue(isFilePathEqual);
    }

    //@@author LokQiJun
    @Test
    void parseCommand_mefInvalidPath_ccmefInvalidException() {
        String filePath = "This is an invalid path";

        String input = ""
                + ConsoleParserConfigurations.COMMAND_MERGE_FILE
                + " -"
                + ConsoleParserConfigurations.COMMAND_MERGE_FILE_ARG_MERGE_FILE_PATH
                + " "
                + filePath;

        assertThrows(ConsoleParserCommandMergeExternalFileInvalidException.class, () ->
                ConsoleParser.parse(input)
        );
    }
}

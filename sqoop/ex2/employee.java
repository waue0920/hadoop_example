// ORM class for table 'employee'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Fri Jul 31 14:21:22 CST 2015
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class employee extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private Integer id;
  public Integer get_id() {
    return id;
  }
  public void set_id(Integer id) {
    this.id = id;
  }
  public employee with_id(Integer id) {
    this.id = id;
    return this;
  }
  private String name;
  public String get_name() {
    return name;
  }
  public void set_name(String name) {
    this.name = name;
  }
  public employee with_name(String name) {
    this.name = name;
    return this;
  }
  private String deg;
  public String get_deg() {
    return deg;
  }
  public void set_deg(String deg) {
    this.deg = deg;
  }
  public employee with_deg(String deg) {
    this.deg = deg;
    return this;
  }
  private Integer salary;
  public Integer get_salary() {
    return salary;
  }
  public void set_salary(Integer salary) {
    this.salary = salary;
  }
  public employee with_salary(Integer salary) {
    this.salary = salary;
    return this;
  }
  private String dept;
  public String get_dept() {
    return dept;
  }
  public void set_dept(String dept) {
    this.dept = dept;
  }
  public employee with_dept(String dept) {
    this.dept = dept;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof employee)) {
      return false;
    }
    employee that = (employee) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.name == null ? that.name == null : this.name.equals(that.name));
    equal = equal && (this.deg == null ? that.deg == null : this.deg.equals(that.deg));
    equal = equal && (this.salary == null ? that.salary == null : this.salary.equals(that.salary));
    equal = equal && (this.dept == null ? that.dept == null : this.dept.equals(that.dept));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof employee)) {
      return false;
    }
    employee that = (employee) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.name == null ? that.name == null : this.name.equals(that.name));
    equal = equal && (this.deg == null ? that.deg == null : this.deg.equals(that.deg));
    equal = equal && (this.salary == null ? that.salary == null : this.salary.equals(that.salary));
    equal = equal && (this.dept == null ? that.dept == null : this.dept.equals(that.dept));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.name = JdbcWritableBridge.readString(2, __dbResults);
    this.deg = JdbcWritableBridge.readString(3, __dbResults);
    this.salary = JdbcWritableBridge.readInteger(4, __dbResults);
    this.dept = JdbcWritableBridge.readString(5, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.name = JdbcWritableBridge.readString(2, __dbResults);
    this.deg = JdbcWritableBridge.readString(3, __dbResults);
    this.salary = JdbcWritableBridge.readInteger(4, __dbResults);
    this.dept = JdbcWritableBridge.readString(5, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(name, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(deg, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(salary, 4 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(dept, 5 + __off, 12, __dbStmt);
    return 5;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(name, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(deg, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(salary, 4 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(dept, 5 + __off, 12, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.id = null;
    } else {
    this.id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.name = null;
    } else {
    this.name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.deg = null;
    } else {
    this.deg = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.salary = null;
    } else {
    this.salary = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.dept = null;
    } else {
    this.dept = Text.readString(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, name);
    }
    if (null == this.deg) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, deg);
    }
    if (null == this.salary) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.salary);
    }
    if (null == this.dept) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, dept);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, name);
    }
    if (null == this.deg) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, deg);
    }
    if (null == this.salary) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.salary);
    }
    if (null == this.dept) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, dept);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(name==null?"null":name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(deg==null?"null":deg, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(salary==null?"null":"" + salary, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dept==null?"null":dept, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(name==null?"null":name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(deg==null?"null":deg, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(salary==null?"null":"" + salary, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dept==null?"null":dept, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.name = null; } else {
      this.name = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.deg = null; } else {
      this.deg = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.salary = null; } else {
      this.salary = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.dept = null; } else {
      this.dept = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.name = null; } else {
      this.name = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.deg = null; } else {
      this.deg = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.salary = null; } else {
      this.salary = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.dept = null; } else {
      this.dept = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    employee o = (employee) super.clone();
    return o;
  }

  public void clone0(employee o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("name", this.name);
    __sqoop$field_map.put("deg", this.deg);
    __sqoop$field_map.put("salary", this.salary);
    __sqoop$field_map.put("dept", this.dept);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("name", this.name);
    __sqoop$field_map.put("deg", this.deg);
    __sqoop$field_map.put("salary", this.salary);
    __sqoop$field_map.put("dept", this.dept);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("id".equals(__fieldName)) {
      this.id = (Integer) __fieldVal;
    }
    else    if ("name".equals(__fieldName)) {
      this.name = (String) __fieldVal;
    }
    else    if ("deg".equals(__fieldName)) {
      this.deg = (String) __fieldVal;
    }
    else    if ("salary".equals(__fieldName)) {
      this.salary = (Integer) __fieldVal;
    }
    else    if ("dept".equals(__fieldName)) {
      this.dept = (String) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("id".equals(__fieldName)) {
      this.id = (Integer) __fieldVal;
      return true;
    }
    else    if ("name".equals(__fieldName)) {
      this.name = (String) __fieldVal;
      return true;
    }
    else    if ("deg".equals(__fieldName)) {
      this.deg = (String) __fieldVal;
      return true;
    }
    else    if ("salary".equals(__fieldName)) {
      this.salary = (Integer) __fieldVal;
      return true;
    }
    else    if ("dept".equals(__fieldName)) {
      this.dept = (String) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/stormstock/fw/event/Transaction.proto

package stormstock.fw.event;

public final class Transaction {
  private Transaction() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface TranEngineExitNotifyOrBuilder
      extends com.google.protobuf.MessageOrBuilder {
  }
  public static final class TranEngineExitNotify extends
      com.google.protobuf.GeneratedMessage
      implements TranEngineExitNotifyOrBuilder {
    // Use TranEngineExitNotify.newBuilder() to construct.
    private TranEngineExitNotify(Builder builder) {
      super(builder);
    }
    private TranEngineExitNotify(boolean noInit) {}
    
    private static final TranEngineExitNotify defaultInstance;
    public static TranEngineExitNotify getDefaultInstance() {
      return defaultInstance;
    }
    
    public TranEngineExitNotify getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return stormstock.fw.event.Transaction.internal_static_stormstock_fw_event_TranEngineExitNotify_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return stormstock.fw.event.Transaction.internal_static_stormstock_fw_event_TranEngineExitNotify_fieldAccessorTable;
    }
    
    private void initFields() {
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;
      
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }
    
    public static stormstock.fw.event.Transaction.TranEngineExitNotify parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static stormstock.fw.event.Transaction.TranEngineExitNotify parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static stormstock.fw.event.Transaction.TranEngineExitNotify parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static stormstock.fw.event.Transaction.TranEngineExitNotify parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static stormstock.fw.event.Transaction.TranEngineExitNotify parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static stormstock.fw.event.Transaction.TranEngineExitNotify parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static stormstock.fw.event.Transaction.TranEngineExitNotify parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static stormstock.fw.event.Transaction.TranEngineExitNotify parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static stormstock.fw.event.Transaction.TranEngineExitNotify parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static stormstock.fw.event.Transaction.TranEngineExitNotify parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(stormstock.fw.event.Transaction.TranEngineExitNotify prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements stormstock.fw.event.Transaction.TranEngineExitNotifyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return stormstock.fw.event.Transaction.internal_static_stormstock_fw_event_TranEngineExitNotify_descriptor;
      }
      
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return stormstock.fw.event.Transaction.internal_static_stormstock_fw_event_TranEngineExitNotify_fieldAccessorTable;
      }
      
      // Construct using stormstock.fw.event.Transaction.TranEngineExitNotify.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }
      
      public Builder clear() {
        super.clear();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return stormstock.fw.event.Transaction.TranEngineExitNotify.getDescriptor();
      }
      
      public stormstock.fw.event.Transaction.TranEngineExitNotify getDefaultInstanceForType() {
        return stormstock.fw.event.Transaction.TranEngineExitNotify.getDefaultInstance();
      }
      
      public stormstock.fw.event.Transaction.TranEngineExitNotify build() {
        stormstock.fw.event.Transaction.TranEngineExitNotify result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      private stormstock.fw.event.Transaction.TranEngineExitNotify buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        stormstock.fw.event.Transaction.TranEngineExitNotify result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return result;
      }
      
      public stormstock.fw.event.Transaction.TranEngineExitNotify buildPartial() {
        stormstock.fw.event.Transaction.TranEngineExitNotify result = new stormstock.fw.event.Transaction.TranEngineExitNotify(this);
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof stormstock.fw.event.Transaction.TranEngineExitNotify) {
          return mergeFrom((stormstock.fw.event.Transaction.TranEngineExitNotify)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(stormstock.fw.event.Transaction.TranEngineExitNotify other) {
        if (other == stormstock.fw.event.Transaction.TranEngineExitNotify.getDefaultInstance()) return this;
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              onChanged();
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                onChanged();
                return this;
              }
              break;
            }
          }
        }
      }
      
      
      // @@protoc_insertion_point(builder_scope:stormstock.fw.event.TranEngineExitNotify)
    }
    
    static {
      defaultInstance = new TranEngineExitNotify(true);
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:stormstock.fw.event.TranEngineExitNotify)
  }
  
  public interface ControllerStartNotifyOrBuilder
      extends com.google.protobuf.MessageOrBuilder {
    
    // required .stormstock.fw.event.ControllerStartNotify.TRANMODE eTranMode = 1;
    boolean hasETranMode();
    stormstock.fw.event.Transaction.ControllerStartNotify.TRANMODE getETranMode();
    
    // optional string beginDate = 2;
    boolean hasBeginDate();
    String getBeginDate();
    
    // optional string endDate = 3;
    boolean hasEndDate();
    String getEndDate();
  }
  public static final class ControllerStartNotify extends
      com.google.protobuf.GeneratedMessage
      implements ControllerStartNotifyOrBuilder {
    // Use ControllerStartNotify.newBuilder() to construct.
    private ControllerStartNotify(Builder builder) {
      super(builder);
    }
    private ControllerStartNotify(boolean noInit) {}
    
    private static final ControllerStartNotify defaultInstance;
    public static ControllerStartNotify getDefaultInstance() {
      return defaultInstance;
    }
    
    public ControllerStartNotify getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return stormstock.fw.event.Transaction.internal_static_stormstock_fw_event_ControllerStartNotify_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return stormstock.fw.event.Transaction.internal_static_stormstock_fw_event_ControllerStartNotify_fieldAccessorTable;
    }
    
    public enum TRANMODE
        implements com.google.protobuf.ProtocolMessageEnum {
      HISTORYMOCK(0, 1),
      REALTIME(1, 2),
      ;
      
      public static final int HISTORYMOCK_VALUE = 1;
      public static final int REALTIME_VALUE = 2;
      
      
      public final int getNumber() { return value; }
      
      public static TRANMODE valueOf(int value) {
        switch (value) {
          case 1: return HISTORYMOCK;
          case 2: return REALTIME;
          default: return null;
        }
      }
      
      public static com.google.protobuf.Internal.EnumLiteMap<TRANMODE>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static com.google.protobuf.Internal.EnumLiteMap<TRANMODE>
          internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<TRANMODE>() {
              public TRANMODE findValueByNumber(int number) {
                return TRANMODE.valueOf(number);
              }
            };
      
      public final com.google.protobuf.Descriptors.EnumValueDescriptor
          getValueDescriptor() {
        return getDescriptor().getValues().get(index);
      }
      public final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }
      public static final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptor() {
        return stormstock.fw.event.Transaction.ControllerStartNotify.getDescriptor().getEnumTypes().get(0);
      }
      
      private static final TRANMODE[] VALUES = {
        HISTORYMOCK, REALTIME, 
      };
      
      public static TRANMODE valueOf(
          com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "EnumValueDescriptor is not for this type.");
        }
        return VALUES[desc.getIndex()];
      }
      
      private final int index;
      private final int value;
      
      private TRANMODE(int index, int value) {
        this.index = index;
        this.value = value;
      }
      
      // @@protoc_insertion_point(enum_scope:stormstock.fw.event.ControllerStartNotify.TRANMODE)
    }
    
    private int bitField0_;
    // required .stormstock.fw.event.ControllerStartNotify.TRANMODE eTranMode = 1;
    public static final int ETRANMODE_FIELD_NUMBER = 1;
    private stormstock.fw.event.Transaction.ControllerStartNotify.TRANMODE eTranMode_;
    public boolean hasETranMode() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    public stormstock.fw.event.Transaction.ControllerStartNotify.TRANMODE getETranMode() {
      return eTranMode_;
    }
    
    // optional string beginDate = 2;
    public static final int BEGINDATE_FIELD_NUMBER = 2;
    private java.lang.Object beginDate_;
    public boolean hasBeginDate() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    public String getBeginDate() {
      java.lang.Object ref = beginDate_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (com.google.protobuf.Internal.isValidUtf8(bs)) {
          beginDate_ = s;
        }
        return s;
      }
    }
    private com.google.protobuf.ByteString getBeginDateBytes() {
      java.lang.Object ref = beginDate_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
        beginDate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    
    // optional string endDate = 3;
    public static final int ENDDATE_FIELD_NUMBER = 3;
    private java.lang.Object endDate_;
    public boolean hasEndDate() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    public String getEndDate() {
      java.lang.Object ref = endDate_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (com.google.protobuf.Internal.isValidUtf8(bs)) {
          endDate_ = s;
        }
        return s;
      }
    }
    private com.google.protobuf.ByteString getEndDateBytes() {
      java.lang.Object ref = endDate_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
        endDate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    
    private void initFields() {
      eTranMode_ = stormstock.fw.event.Transaction.ControllerStartNotify.TRANMODE.HISTORYMOCK;
      beginDate_ = "";
      endDate_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;
      
      if (!hasETranMode()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeEnum(1, eTranMode_.getNumber());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getBeginDateBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBytes(3, getEndDateBytes());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, eTranMode_.getNumber());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getBeginDateBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, getEndDateBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }
    
    public static stormstock.fw.event.Transaction.ControllerStartNotify parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static stormstock.fw.event.Transaction.ControllerStartNotify parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static stormstock.fw.event.Transaction.ControllerStartNotify parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static stormstock.fw.event.Transaction.ControllerStartNotify parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static stormstock.fw.event.Transaction.ControllerStartNotify parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static stormstock.fw.event.Transaction.ControllerStartNotify parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static stormstock.fw.event.Transaction.ControllerStartNotify parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static stormstock.fw.event.Transaction.ControllerStartNotify parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static stormstock.fw.event.Transaction.ControllerStartNotify parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static stormstock.fw.event.Transaction.ControllerStartNotify parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(stormstock.fw.event.Transaction.ControllerStartNotify prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements stormstock.fw.event.Transaction.ControllerStartNotifyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return stormstock.fw.event.Transaction.internal_static_stormstock_fw_event_ControllerStartNotify_descriptor;
      }
      
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return stormstock.fw.event.Transaction.internal_static_stormstock_fw_event_ControllerStartNotify_fieldAccessorTable;
      }
      
      // Construct using stormstock.fw.event.Transaction.ControllerStartNotify.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }
      
      public Builder clear() {
        super.clear();
        eTranMode_ = stormstock.fw.event.Transaction.ControllerStartNotify.TRANMODE.HISTORYMOCK;
        bitField0_ = (bitField0_ & ~0x00000001);
        beginDate_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        endDate_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return stormstock.fw.event.Transaction.ControllerStartNotify.getDescriptor();
      }
      
      public stormstock.fw.event.Transaction.ControllerStartNotify getDefaultInstanceForType() {
        return stormstock.fw.event.Transaction.ControllerStartNotify.getDefaultInstance();
      }
      
      public stormstock.fw.event.Transaction.ControllerStartNotify build() {
        stormstock.fw.event.Transaction.ControllerStartNotify result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      private stormstock.fw.event.Transaction.ControllerStartNotify buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        stormstock.fw.event.Transaction.ControllerStartNotify result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return result;
      }
      
      public stormstock.fw.event.Transaction.ControllerStartNotify buildPartial() {
        stormstock.fw.event.Transaction.ControllerStartNotify result = new stormstock.fw.event.Transaction.ControllerStartNotify(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.eTranMode_ = eTranMode_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.beginDate_ = beginDate_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.endDate_ = endDate_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof stormstock.fw.event.Transaction.ControllerStartNotify) {
          return mergeFrom((stormstock.fw.event.Transaction.ControllerStartNotify)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(stormstock.fw.event.Transaction.ControllerStartNotify other) {
        if (other == stormstock.fw.event.Transaction.ControllerStartNotify.getDefaultInstance()) return this;
        if (other.hasETranMode()) {
          setETranMode(other.getETranMode());
        }
        if (other.hasBeginDate()) {
          setBeginDate(other.getBeginDate());
        }
        if (other.hasEndDate()) {
          setEndDate(other.getEndDate());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized() {
        if (!hasETranMode()) {
          
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              onChanged();
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                onChanged();
                return this;
              }
              break;
            }
            case 8: {
              int rawValue = input.readEnum();
              stormstock.fw.event.Transaction.ControllerStartNotify.TRANMODE value = stormstock.fw.event.Transaction.ControllerStartNotify.TRANMODE.valueOf(rawValue);
              if (value == null) {
                unknownFields.mergeVarintField(1, rawValue);
              } else {
                bitField0_ |= 0x00000001;
                eTranMode_ = value;
              }
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              beginDate_ = input.readBytes();
              break;
            }
            case 26: {
              bitField0_ |= 0x00000004;
              endDate_ = input.readBytes();
              break;
            }
          }
        }
      }
      
      private int bitField0_;
      
      // required .stormstock.fw.event.ControllerStartNotify.TRANMODE eTranMode = 1;
      private stormstock.fw.event.Transaction.ControllerStartNotify.TRANMODE eTranMode_ = stormstock.fw.event.Transaction.ControllerStartNotify.TRANMODE.HISTORYMOCK;
      public boolean hasETranMode() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      public stormstock.fw.event.Transaction.ControllerStartNotify.TRANMODE getETranMode() {
        return eTranMode_;
      }
      public Builder setETranMode(stormstock.fw.event.Transaction.ControllerStartNotify.TRANMODE value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        eTranMode_ = value;
        onChanged();
        return this;
      }
      public Builder clearETranMode() {
        bitField0_ = (bitField0_ & ~0x00000001);
        eTranMode_ = stormstock.fw.event.Transaction.ControllerStartNotify.TRANMODE.HISTORYMOCK;
        onChanged();
        return this;
      }
      
      // optional string beginDate = 2;
      private java.lang.Object beginDate_ = "";
      public boolean hasBeginDate() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      public String getBeginDate() {
        java.lang.Object ref = beginDate_;
        if (!(ref instanceof String)) {
          String s = ((com.google.protobuf.ByteString) ref).toStringUtf8();
          beginDate_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      public Builder setBeginDate(String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        beginDate_ = value;
        onChanged();
        return this;
      }
      public Builder clearBeginDate() {
        bitField0_ = (bitField0_ & ~0x00000002);
        beginDate_ = getDefaultInstance().getBeginDate();
        onChanged();
        return this;
      }
      void setBeginDate(com.google.protobuf.ByteString value) {
        bitField0_ |= 0x00000002;
        beginDate_ = value;
        onChanged();
      }
      
      // optional string endDate = 3;
      private java.lang.Object endDate_ = "";
      public boolean hasEndDate() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      public String getEndDate() {
        java.lang.Object ref = endDate_;
        if (!(ref instanceof String)) {
          String s = ((com.google.protobuf.ByteString) ref).toStringUtf8();
          endDate_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      public Builder setEndDate(String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        endDate_ = value;
        onChanged();
        return this;
      }
      public Builder clearEndDate() {
        bitField0_ = (bitField0_ & ~0x00000004);
        endDate_ = getDefaultInstance().getEndDate();
        onChanged();
        return this;
      }
      void setEndDate(com.google.protobuf.ByteString value) {
        bitField0_ |= 0x00000004;
        endDate_ = value;
        onChanged();
      }
      
      // @@protoc_insertion_point(builder_scope:stormstock.fw.event.ControllerStartNotify)
    }
    
    static {
      defaultInstance = new ControllerStartNotify(true);
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:stormstock.fw.event.ControllerStartNotify)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_stormstock_fw_event_TranEngineExitNotify_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_stormstock_fw_event_TranEngineExitNotify_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_stormstock_fw_event_ControllerStartNotify_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_stormstock_fw_event_ControllerStartNotify_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n)src/stormstock/fw/event/Transaction.pr" +
      "oto\022\023stormstock.fw.event\"\026\n\024TranEngineEx" +
      "itNotify\"\256\001\n\025ControllerStartNotify\022F\n\teT" +
      "ranMode\030\001 \002(\01623.stormstock.fw.event.Cont" +
      "rollerStartNotify.TRANMODE\022\021\n\tbeginDate\030" +
      "\002 \001(\t\022\017\n\007endDate\030\003 \001(\t\")\n\010TRANMODE\022\017\n\013HI" +
      "STORYMOCK\020\001\022\014\n\010REALTIME\020\002"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_stormstock_fw_event_TranEngineExitNotify_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_stormstock_fw_event_TranEngineExitNotify_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_stormstock_fw_event_TranEngineExitNotify_descriptor,
              new java.lang.String[] { },
              stormstock.fw.event.Transaction.TranEngineExitNotify.class,
              stormstock.fw.event.Transaction.TranEngineExitNotify.Builder.class);
          internal_static_stormstock_fw_event_ControllerStartNotify_descriptor =
            getDescriptor().getMessageTypes().get(1);
          internal_static_stormstock_fw_event_ControllerStartNotify_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_stormstock_fw_event_ControllerStartNotify_descriptor,
              new java.lang.String[] { "ETranMode", "BeginDate", "EndDate", },
              stormstock.fw.event.Transaction.ControllerStartNotify.class,
              stormstock.fw.event.Transaction.ControllerStartNotify.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  // @@protoc_insertion_point(outer_class_scope)
}
